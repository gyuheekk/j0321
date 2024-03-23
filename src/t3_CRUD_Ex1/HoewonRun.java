package t3_CRUD_Ex1;

import java.util.Scanner;

public class HoewonRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HoewonService service = new HoewonService();
		
		boolean run = true;
		String name = "";
		
		while(run) {
			System.out.print("1.회원등록 2.전체조회 3.개별조회 4.수정 5.삭제 6.종료 ==> ");
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					service.setInput(); //회원자료등록
					break;
				case 2:
					service.getList(); //회원 전체조회
					break;
				case 3:
					System.out.print("검색할 성명을 입력하세요? ");
					name = sc.next();
					service.getSearch(name); //회원 개별조회
					break;
				case 4:
					System.out.print("수정할 성명을 입력하세요? ");
					name = sc.next();
					service.setUpdate(name); //회원자료 수정
					break;
				case 5:
					System.out.print("삭제할 성명을 입력하세요? ");
					name = sc.next();
					service.setDelete(name); //회원자료 삭제
					break;
				default:
					run = false;
			}
		}
		System.out.println("수고하셨습니다.");
		
		sc.close();
	}
}
