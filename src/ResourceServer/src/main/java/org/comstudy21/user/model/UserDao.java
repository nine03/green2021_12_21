package org.comstudy21.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.comstudy21.dbcp.JdbcUtil;
import org.json.JSONArray;
import org.json.JSONObject;

public class UserDao {
	public static final String SQL_SELECT = "SELECT * FROM USER";
	public static final String SQL_INSERT = "INSERT INTO USER(name, email, phone)values(?,?,?)";
	public static final String SQL_UPDATE = "UPDATE USER SET NAME=?, EMAIL=?, PHONE=? WHERE NO=?";
	public static final String SQL_DELETE = "DELETE FROM USER WHERE NO=?";
	public static final String SQL_SELECT_ONE = "SELECT * FROM USER WHERE NO=?";

	public static Statement stmt = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public static Connection conn = null;
	
	public static List<UserDto> selectAll() {
		List<UserDto> list = new ArrayList<UserDto>();
		conn = JdbcUtil.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT);
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				list.add(new UserDto(no, name, email, phone));
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
	
	public static JSONObject selectAllJSONArr() {
		List<UserDto> list = selectAll();
		JSONArray jsonArr = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			jsonArr.put(list.get(i).toJSONObject());
		}
		JSONObject root = new JSONObject();
		root.put("member", jsonArr);
		return root;
	}

	public static UserDto selectOne(UserDto dto) {
		conn = JdbcUtil.getConnection();
		UserDto saram = null;
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setString(1, dto.getNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				saram = new UserDto(no, name, email, phone);
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

	public static UserDto selectById(UserDto dto) {
		return null;
	}

	public static List<UserDto> selectByName(UserDto dto) {
		return null; 
	}

	public static void insert(UserDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
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

	public static void update(UserDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getNo());
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

	public static void delete(UserDto dto) {
		conn = JdbcUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, dto.getNo());
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
