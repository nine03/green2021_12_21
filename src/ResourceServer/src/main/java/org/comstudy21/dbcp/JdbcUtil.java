package org.comstudy21.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

	public static Connection getConnection() {
		String protocol = "jdbc:mariadb://";
		String ip = "127.0.0.1";
		String port = "3306";
		String db = "test";
		String url = String.format("%s%s:%s/%s", protocol, ip, port, db);
		String user = "root";
		String password = "1234";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
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
