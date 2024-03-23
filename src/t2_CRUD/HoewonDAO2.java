package t2_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoewonDAO2 {
	private Connection conn = null;
	
	
	public HoewonDAO2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaclass";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패 ㅠㅠ");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패 ㅠㅠ");
		}
	}
	
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}

	// 전체 회원 조회
	public void getlist() {
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from hoewon"; 
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("번호 : " + rs.getInt("idx"));
				System.out.println("성명 : " + rs.getString("name"));
				System.out.println("나이 : " + rs.getInt("age"));
				System.out.println("성별 : " + rs.getString("gender"));
				System.out.println("주소 : " + rs.getString("address"));
				System.out.println();
			}
				
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}
	}
}
