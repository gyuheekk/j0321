package t6_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class NetpayDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	NetpayVO vo = null;
	String sql = "";
	
	public NetpayDAO() {
		String url = "jsbc:mysql://localhost:3306.javaclass";
		String user = "atom";
		String password = "1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패" + e.getMessage());
		}
	}
	
	//conn객체 Close()
	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}
	
	//pstmt객체 Close
	public void pstmtClose() {
		try {
			if(pstmt != null) pstmt.close();
			pstmt.close();
		} catch (SQLException e) {}
	}
	
	//rs객체 Close
	public void rsClose() {
		try {
			if(rs != null) rs.close();
			rs.close();
		} catch (SQLException e) {}
	}
}	
	
