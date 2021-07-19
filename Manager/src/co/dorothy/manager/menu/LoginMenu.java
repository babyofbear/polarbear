package co.dorothy.manager.menu;

import java.util.Scanner;

import co.dorothy.manager.member.service.MemberService;
import co.dorothy.manager.member.serviceImpl.MemberServiceImpl;
import co.dorothy.manager.member.vo.MemberVO;

public class LoginMenu {
	private MemberService MemberDao = new MemberServiceImpl();
	private Scanner sc = new Scanner(System.in);
	
	//사용자 메뉴 객체 생성
	private UserMenu user = new UserMenu();
	//관리자 메뉴 객체 생성
	private AdminMenu admin = new AdminMenu();
	
	private void loginTitle() {
		System.out.println("==================================");
		System.out.println("========= 로     그     인 =========");
		System.out.println("==================================");
	}
	
	private MemberVO loginCheck() {
		MemberVO vo = new MemberVO();
		boolean b = false;
		int loginCount = 1;
		do {
			loginTitle(); //타이틀 출력
			System.out.print("아이디를 입력하세요>>> ");
			vo.setId(sc.next());sc.nextLine();
			System.out.print("패스워드를 입력하세요>>> ");
			vo.setPassword(sc.next());sc.nextLine();
			
			vo = MemberDao.loginCheck(vo);
			if(vo.getName() !=null) {
				b= true;
			}else {
				System.out.println("존재하지 않는 아이디 또는 패스워드 입니다.");
				if(loginCount == 3) {
					b = true;
					System.out.println("!!로그인 시도 "+ loginCount +"회 초과 관리자에게 문의하세요.!!");
					vo = new MemberVO(); // 
				}else {
					loginCount++;
				}
			}
		}while(!b) ; 
		return vo; //
	}
	
	public void login() {
		MemberVO vo = new MemberVO();
		vo = loginCheck();
		if(vo.getId() !=null) {
			//요기서 주메뉴 호출하면 된다.
			if(vo.getAuthor().equals("ADMIN")) {
				admin.run(vo); //어드민 객체의 어드민 메뉴 호출
			}else {
				user.run(vo);
			}
			System.out.println("OK");
		}
		
		sc.close();
	}
}
