package t3_CRUD_Ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HoewonDAO {
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	private String sql = "";
	
	public HoewonDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/javaclass";
			String user = "atom";
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연동 실패");
		}
	}

	public void connClose() {
		try {
			conn.close();
		} catch (SQLException e) {}
	}

	//회원등록
	public void setInput(HoewonVO vo) {
		try {
			stmt = conn.createStatement();
			sql = "insert into howeon values (default, '"+vo.getName()+"',"+vo.getAge()+",'"+vo.getGender()+"','"+vo.getAddress()+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}
	}

	//전체 조회
	public ArrayList<HoewonVO> getList() {
		ArrayList<HoewonVO> vos = new ArrayList<HoewonVO>();
		HoewonVO vo = null;
		try {
			stmt = conn.createStatement();
			sql = "select * from hoewon";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				vo = new HoewonVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}
		
		return vos;
	}

	// 개별자료검색
	public HoewonVO getSearch(String name) {
		HoewonVO vo = new HoewonVO();
		
		try {
			stmt = conn.createStatement();
			sql = "select * from hoewon where name='"+name+"'";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}
			
		return vo;
	}

	//수정처리
	public void setUpdate(int idx, int choice, String content) {
		try {
			stmt = conn.createStatement();
			if(choice == 1) {
				sql = "update hoewon set name='"+content+"' where idx="+idx;
			}
			else if(choice == 2) {
				sql = "update hoewon set age="+Integer.parseInt(content)+" where idx="+idx;
			}
			else if(choice == 3) {
				sql = "update hoewon set gender='"+content+"' where idx=" + idx;
			}
			else if(choice == 4) {
				sql = "update hoewon set address='"+content+"' where idx="+idx;
			}
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("SQL오류 : " + e.getMessage());
		}
			
	}

	}
	
	
	

