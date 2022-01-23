package org.comstudy21.saram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.dbcp.JdbcUtil;

public class SaramDao {

			// 테이블의 내용을 읽어 온다.
			// Statement 읽어온다 , ResultSet 담는다 , sql
			// vector에 저장했던거 db에 저장한다. 
			public static final String SQL_SELECT = "SELECT * FROM SARAM"; // 쿼리문
			public static final String SQL_INSERT = "INSERT INTO SARAM(id,name,age)values(?,?,?)"; // ? 는 변수 들어갈 자리만 format이랑 비스하다
			public static final String SQL_UPDATE = "UPDATE SARAM SET ID=?,NAME=?,AGE=? WHERE NO=?"; // ?로 이용해서 변수값을 넣어준다.
			public static final String SQL_DELETE = "DELETE FROM SARAM WHERE NO=?";
			public static final String SQL_SELECT_ONE = "SELECT * FROM SARAM WHERE NO=?";
			
			public static final String SQL_SELECT_BY_NAME = "SELECT * FROM SARAM WHERE NAME=?";
			public static final String SQL_SELECT_BY_ID = "SELECT * FROM SARAM WHERE ID=?";
			
			public static Statement stmt = null;
			public static PreparedStatement pstmt = null;
			public static ResultSet rs = null; // 실행한 결과를 rs에 받는다.
			public static Connection conn = null;
			
		public static List<SaramDto> selectAll()  {
		List<SaramDto> list = new ArrayList<SaramDto>();
		conn = JdbcUtil.getConnection();
		// 테이블의 내용을 읽어 온다.
		// Statement 읽어온다 , ResultSet 담는다 , sql Statement 이터레이터랑 비슷하다.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT); // 리턴해주는 타입 
			while(rs.next()) {
				int no = rs.getInt(1); // 여기서는 0부터가 아니라 1부터 들어가야한다.
				String id = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				list.add(new SaramDto(no,id,name,age)); // 왼쪽 정렬할려면 - 마이너스를 해줘야한다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // 생성된거에 역순으로 처리해줘야한다.
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				JdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
		
		public static SaramDto selectOne(SaramDto dto) {
		      conn = JdbcUtil.getConnection();
		      SaramDto saram = null;
		      try {
		         pstmt = conn.prepareStatement(SQL_SELECT_ONE);
		         pstmt.setInt(1, dto.getNo());
		         rs = pstmt.executeQuery();
		         while (rs.next()) {
		            int no = rs.getInt(1);
		            String id = rs.getString(2);
		            String name = rs.getString(3);
		            int age = rs.getInt(4);
		            saram = new SaramDto(no, id, name, age);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         try {
		            if (rs != null)
		               rs.close();
		            if (stmt != null)
		               stmt.close();
		            JdbcUtil.close(conn);
		         } catch (SQLException e) {
		            e.printStackTrace();
		         }
		      }
		      return saram;
		   }

	
	public static SaramDto selectById(SaramDto dto) { // id로 검색하는거 
		// id로 검색해서 넘겨줘야함 dto select one 
		conn = JdbcUtil.getConnection();
		 SaramDto saram = null;
	      try {
	         pstmt = conn.prepareStatement(SQL_SELECT_BY_ID);
	         pstmt.setString(1, dto.getId());
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	            int no = rs.getInt(1);
	            String id = rs.getString(2);
	            String name = rs.getString(3);
	            int age = rs.getInt(4);
	            saram = new SaramDto(no, id, name, age);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if (rs != null)
	               rs.close();
	            if (stmt != null)
	               stmt.close();
	            JdbcUtil.close(conn);
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return saram;
	   }
	
	
	public static List<SaramDto> selectByName(SaramDto dto) { // 이름로 검색하는거 
		// 중복된 이름있을수도있으니깐 list로 넘기기  select all
		List<SaramDto> list = new ArrayList<SaramDto>();
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_BY_NAME);
			pstmt.setString(1, dto.getName());
			rs = pstmt.executeQuery(); // 리턴해주는 타입 
			while(rs.next()) {
				int no = rs.getInt(1); // 여기서는 0부터가 아니라 1부터 들어가야한다.
				String id = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				list.add(new SaramDto(no,id,name,age)); // 왼쪽 정렬할려면 - 마이너스를 해줘야한다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally { // 생성된거에 역순으로 처리해줘야한다.
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				JdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public static void insert(SaramDto dto) {  
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			int cnt = pstmt.executeUpdate(); //리턴 처리된횟수
			if(cnt == 0) {
				System.out.println(">>> 입력 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류!");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} // 처리된걸 다시 원점으로 돌려라 처리하던걸 취소하겠다.
			e.printStackTrace();
		}finally {
				try {
					if(pstmt != null) pstmt.close();
					JdbcUtil.close(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static void update(SaramDto dto) { 
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.setInt(4, dto.getNo());
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				System.out.println(">>> 수정 실패!");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				JdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete(SaramDto dto) {  
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, dto.getNo());
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				System.out.println(">>> 삭제 실패!");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				JdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
