package t6_ex;

import java.util.Scanner;

public class NetpayRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SalaryService salaryService = new SalaryService();
		InsaService insaService = new InsaService();
		NetpayService netpayService = new NetpayService();
		
		int choice = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("\n\t *** 인사/급여관리 프로그램 ***");
			System.out.print("메뉴선택? 1.본봉관리 2.인사관리 3.급여관리 ==> ");
			choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					while(true) {
						System.out.println("\n\t *** 본봉관리 ***");
						System.out.print("메뉴선택? 1.직급/본봉입력  2:직급/본봉조회  3:본봉수정  4:직급삭제  0:종료 ==> ");
						choice = sc.nextInt();
						if(choice == 1) salaryService.setSalaryInput();
						else if(choice == 2) salaryService.getSalaryList();
						else if(choice == 3) salaryService.setSalaryUpdate();
						else if(choice == 4) salaryService.setSalaryDelete();
						else if (choice == 0)	{
							System.out.println("본봉관리 프로그램을 종료합니다.");
							break;
						}
						else System.out.println("1/2/3/4/0 중 입력해주세요");
					}
					break;
				case 2:
					while(true) {
						System.out.println("\n\t *** 인사관리 ***");
						System.out.print("메뉴선택? 1.사원등록  2:사원전체조회  3:사원개별조회  0:종료 ==> ");
						choice = sc.nextInt();
						if(choice == 1) insaService.setInsainput();
						else if(choice == 2) insaService.getInsaList();
						else if(choice == 3) insaService.getInsaSearch();
						else if(choice == 0) {
							System.out.println("인사관리 프로그램을 종료합니다.");
							break;
						}
						else System.out.println("1/2/3/0중 입력해주세요.");
					}
					break;
				case 3:
					while(true) {
						System.out.println("\n\t *** 급여관리 ***");
						System.out.print("1. 사번을 입력하세요? ==> ");
						System.out.print("2. 초과시간을 입력하세요? ==> ");
						netpayService.getNetpaySearch();
					}
					break;
				default:
					run = false;
			}
		}
		System.out.println("=========================================================");
		System.out.println("프로그램을 종료합니다.");
		
		sc.close();
	}
}
