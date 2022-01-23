package org.comstudy21.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	public static Connection getConnection() {
		String protocol = "jdbc:mariadb://"; // 프로토콜
		String ip = "127.0.0.1";
		String port = "3306"; 
		String db = "test"; // comstudy21
		String url = String.format("%s%s:%s/%s", protocol,ip,port,db);
		String user = "root"; // root comstudy21
		String password = "1234"; // comstudy21
		
		try {
			Class.forName("org.mariadb.jdbc.Driver"); // class는 확장자를 뺴준다. 예외가 발생 
			
			// 커넥션 접속하고 접속 정보를 보내준다
			return DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found ...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL exception ...");
			e.printStackTrace();
		} 
		return null;
	}
	 public static void close(Connection conn) {
	      if(conn != null) {
	         try {
	            conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   } // end of close

	}
