package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {
	public static void close(ResultSet rs, Connection conn, Statement stmt) {
		
		if(rs != null) {
			try {
				// 자원 반납
				rs.close();
			} catch(Exception e) {
				// 반납 안 됐으면 예외 메세지 출력
				e.printStackTrace();
			}
		}
		
		if(stmt != null) {
			try {
				// 자원 반납
				stmt.close();
			} catch(Exception e) {
				// 반납 안 됐으면 예외 메세지 출력
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				// 자원 반납
				conn.close();
			} catch(Exception e) {
				// 반납 안 됐으면 예외 메세지 출력
				e.printStackTrace();
			}
		}
		
			
			
			
			
		
	}
	
	public static Connection getConnection() throws Exception {
		// db 드라이버 로딩
		Class.forName("org.mariadb.jdbc.Driver");
		//db연결정보 입력하여 db연결
		Connection conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/employees", "root", "java1234");
		
		return conn;
	}
}
