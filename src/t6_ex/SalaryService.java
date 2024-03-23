package t6_ex;

import java.util.Scanner;

public class SalaryService {
	Scanner sc = new Scanner(System.in); //스캐너 안 닫아도 됨
	SalaryDAO dao = new SalaryDAO();
	NetpayVO vo = null;
	
	int res, choice = 0;
	String ans = "N";

	// 직급/봉봉 입력
	public void setSalaryInput() {
		vo = new NetpayVO();
		
		while(true) {
			System.out.println("\n ** 직급/본봉 입력처리 **");
			String name, jikkub = "";
			int bonbong = 0;
			
			while(true) {
				
			}
		}
		
	}

}
