package t1_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test3DAO {
	Connection conn = null;
	
	public Test3DAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javacalss";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색실패 ㅠ ㅠ" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB연결 실패 ㅠ ㅠ" + e.getMessage());
		}
	}
	
	public void connClose() {
		try {
			conn.close();
			System.out.println("DB 연결 종료");
		} catch (SQLException e) {}
	}
}
