package co.dorothy.prj.app; //phase 6

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.dorothy.prj.service.MemberService;
import co.dorothy.prj.serviceImpl.MemberServiceImpl;
import co.dorothy.prj.vo.MemberVO;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private MemberService dao = new MemberServiceImpl();
	
	private void menuTitle() {
		System.out.println("================================");
		System.out.println("==========회원정보 관리 시스템========");
		System.out.println("=========1. 회원 목록 조회 =========");
		System.out.println("=========2. 회원 정보 조회 =========");
		System.out.println("=========3. 회원 정보 등록 =========");
		System.out.println("=========4. 회원 정보 수정 =========");
		System.out.println("=========5. 회원 정보 삭제 =========");
		System.out.println("=========6. 종       료 =========");
		System.out.println("================================");
		System.out.println("===== 원하는 작업 번호를 선택하세요 ====");
	}
	
	private void mainMenu() {
		int jobNo;
		boolean b = false;
		
		do {
			menuTitle();
			switch(jobNo = sc.nextInt()) {
				case 1:
					memberSelectList();
					break;
				case 2:
					memberSelect();
					break;
				case 3:
					memberInsert();
					break;
				case 4:
					memberUpdate();
					break;
				case 5:
					memberDelete();
					break;
				case 6:
					b = true;
					System.out.println("============ Good Bye!!! =======");
					break;
			}
		}while(!b); {
			
		}
	}

	private void memberDelete() {
		// TODO 회원 정보 삭제
		MemberVO vo = new MemberVO();
		System.out.println("삭제할 회원의 ID를 입력하세요>>> ");
		vo.setId(sc.next());sc.nextLine();
		
		int n = dao.memberDelete(vo);
		if( n !=0) {
			System.out.println("회원의 정보가 삭제되었습니다.");
		} else {
			System.out.println("회원 정보 삭제에 실패했습니다.");
		}
	}

	private void memberUpdate() {
		// TODO 회원 정보 수정
		MemberVO vo = new MemberVO();
		System.out.print("수정할 회원의 ID를 입력하세요.>>> ");
		vo.setId(sc.next());sc.nextLine();
		System.out.print("이름을 입력하세요.>>");
		vo.setName(sc.next());sc.nextLine();
		System.out.print("주소를 입력하세요.>>");
		vo.setAddress(sc.next());sc.nextLine();
		System.out.print("전화번호를 입력하세요.>>");
		vo.setTel(sc.next());sc.nextLine();
		
		int n = dao.memberUpdate(vo);
		
		if( n !=0) {
			System.out.println("회원의 정보가 수정되었습니다.");
		} else {
			System.out.println("회원 정보 수정에 실패했습니다.");
		}
		
		
	}

	private void memberInsert() {
		// TODO 회원 정보 추가
		MemberVO vo = new MemberVO();
		System.out.print("ID를 입력하세요.>>");
		vo.setId(sc.next());sc.nextLine();
		System.out.print("Password를 입력하세요.>>");
		vo.setPassword(sc.next());sc.nextLine();
		System.out.print("이름을 입력하세요.>>");
		vo.setName(sc.next());sc.nextLine();
		System.out.print("주소를 입력하세요.>>");
		vo.setAddress(sc.next());sc.nextLine();
		System.out.print("전화번호를 입력하세요.>>");
		vo.setTel(sc.next());sc.nextLine();
		System.out.print("나이를 입력하세요.>>");
		vo.setAge(sc.nextInt());
		
		int n = dao.memberInsert(vo);
		if(n !=0 ) {
			System.out.println("입력이 완료되었습니다.");
		} else {
			System.out.println("입력이 실패했습니다.");
		}
	}

	private void memberSelect() {
		// TODO 회원 한 명 조회
		MemberVO vo = new MemberVO();
		System.out.print("조회할 회원 ID를 입력하세요>>> ");
		vo.setId(sc.next());sc.nextLine();
		
		vo = dao.memberSelect(vo);
		vo.toString();
	}

	private void memberSelectList() {
		// TODO 회원 전체 목록 조회
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = dao.memberSelectList();
		for(MemberVO member : members) {
			member.toString();
		}
	}
	
	public void run() {
		mainMenu();
		sc.close();
	}
}
