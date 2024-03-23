package t3_CRUD_Ex2;

import java.util.ArrayList;
import java.util.Scanner;

public class HoewonService {
	Scanner sc = new Scanner(System.in);

	//회원자료 등록처리
	public void setInput() {
		HoewonDAO dao = new HoewonDAO();
		
		String name, gender, address;
		int age;
		
		System.out.println("회원 정보 등록하기==> ");
		System.out.print("성명 : ");
		name = sc.next();
		System.out.print("나이 : ");
		age = sc.nextInt();
		System.out.print("성별 : ");
		gender = sc.next();
		System.out.print("주소 : ");
		address = sc.next();
		
		HoewonVO vo = new HoewonVO();
		vo.setName(name);
		vo.setAge(age);
		vo.setGender(gender);
		vo.setAddress(address);
		
		dao.setInput(vo);
		System.out.println("회원 등록 완료!");
		
		dao.connClose();
		
	}

	// 회원자료 전체조회
	public void getList() {
		HoewonDAO dao = new HoewonDAO();
		
		ArrayList<HoewonVO> vos = dao.getList();
		HoewonVO vo = new HoewonVO();
		
		System.out.println("=========================================");
		System.out.println("번호\t성명\t나이\t성별\t주소");
		System.out.println("=========================================");
		for(int i=0; i<vos.size(); i++) {
			vo = vos.get(i);
			System.out.print((i+1) + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getAge() + "\t");
			System.out.print(vo.getGender() + "\t");
			System.out.print(vo.getAddress() + "\n");
		}
		System.out.println("=========================================");
		System.out.println("\t\t\t총 : " +vos.size()+"건");
		dao.connClose();
	}

	// 개별자료검색
	public void getSearch(String name) {
		HoewonDAO dao = new HoewonDAO();
		
		HoewonVO vo = dao.getSearch(name);
		
		System.out.println(name + "으(로) 검색된 자료?");
		if(vo.getName() != null) {
			System.out.println("번호 : " +vo.getIdx());
			System.out.println("성명 : " +vo.getName());
			System.out.println("나이 : " +vo.getAge());
			System.out.println("성별 : " +vo.getGender());
			System.out.println("주소 : " +vo.getAddress());
		}
		else {
			System.out.println("검색하신 이름은 없는 이름입니다.");
		}
		dao.connClose();
	}

	// 회원정보 수정
	public void setUpdate(String name) {
		HoewonDAO dao = new HoewonDAO();
		
		HoewonVO vo = dao.getSearch(name);
		
		System.out.println(name + "으(로) 검색된 자료?");
		if(vo.getName() != null) {
			System.out.println("번호 : " +vo.getIdx());
			System.out.println("성명 : " +vo.getName());
			System.out.println("나이 : " +vo.getAge());
			System.out.println("성별 : " +vo.getGender());
			System.out.println("주소 : " +vo.getAddress());
			System.out.print("수정 : 1.성명 2.나이 3.성별 4.주소");
			int choice = sc.nextInt();
			System.out.print("수정할 내용? ");
			String content = sc.next();
			dao.setUpdate(vo.getIdx(), choice, content);
			System.out.println("===> 자료가 수정되었습니다.");
		}
		else {
			System.out.println("검색하신 이름은 없는 이름입니다.");
		}
		dao.connClose();
	}

}
