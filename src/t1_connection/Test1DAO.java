package t1_connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Test1DAO {

	public Test1DAO() { //기본생성자
		
		try {
			// 1. JDBC 드라이버 검색
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공*^^*");
			
			// 2. DB서버에 연결(연동)후 데이터베이스 사용준비 작업
			String url = "jdbc:mysql://localhost:3306/javaclass";
			String user = "atom";
			String password = "1234";
			DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공~!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패"); //url, 계정, 비밀번호 확인
		} finally {
			System.out.println("작업끝-!");
		}
		
	}
	
}
