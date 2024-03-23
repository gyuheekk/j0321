package t2_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HoewonDAO3 {
	private Connection conn = null;
	
	
	public HoewonDAO3() {
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
	public void getList() {
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from hoewon"; 
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println("====================================");
			System.out.println("번호\t성명\t나이\t성별\t주소");
			System.out.println("====================================");
			while(rs.next()) {
				System.out.print(rs.getInt("idx") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getInt("age") + "\t");
				System.out.print(rs.getString("gender") + "\t");
				System.out.print(rs.getString("address") + "\n");
			}
			System.out.println("====================================");
				
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}
	}
}
