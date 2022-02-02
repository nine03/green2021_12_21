package org.comstudy21.saram.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.dbcp.JdbcUtil;
import org.json.JSONArray;

public class SaramDao {
	public static final String SQL_SELECT = "SELECT * FROM SARAM";
	public static final String SQL_INSERT = "INSERT INTO SARAM(id, name, age)values(?,?,?)";
	public static final String SQL_UPDATE = "UPDATE SARAM SET ID=?, NAME=?, AGE=? WHERE NO=?";
	public static final String SQL_DELETE = "DELETE FROM SARAM WHERE NO=?";
	public static final String SQL_SELECT_ONE = "SELECT * FROM SARAM WHERE NO=?";

	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public static Connection conn = null;
	
	public static List<SaramDto> selectAll() {
		List<SaramDto> list = new ArrayList<SaramDto>();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT);
			while (rs.next()) {
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				list.add(new SaramDto(no, id, name, age));
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
		return list;
	}
	
	public static JSONArray selectAllJSONArr() {
		List<SaramDto> list = selectAll();
		JSONArray jsonArr = new JSONArray();
		for(int i = 0; i<list.size(); i++) {
			jsonArr.put(list.get(i).toJSONObject());
		}
		return jsonArr;
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

	public static SaramDto selectById(SaramDto dto) {
		return null;
	}

	public static List<SaramDto> selectByName(SaramDto dto) {
		return null; 
	}

	public static void insert(SaramDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			int cnt = pstmt.executeUpdate();
			if(cnt == 0) {
				System.out.println(">>> 입력 실패!");
				conn.rollback();
			}
		} catch (SQLException e) {
			System.out.println(">>> SQL 오류!");
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
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
			int cnt  = pstmt.executeUpdate();
			if(cnt==0) {
				System.out.println(">>> 수정 실패!");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
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
			int cnt  = pstmt.executeUpdate();
			if(cnt==0) {
				System.out.println(">>> 삭제 실패!");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				JdbcUtil.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
