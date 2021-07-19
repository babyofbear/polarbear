package co.dorothy.manager.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.dorothy.manager.board.service.BoardService;
import co.dorothy.manager.board.serviceImple.BoardServiceImpl;
import co.dorothy.manager.board.vo.BoardVO;
import co.dorothy.manager.member.service.MemberService;
import co.dorothy.manager.member.serviceImpl.MemberServiceImpl;
import co.dorothy.manager.member.vo.MemberVO;

public class UserMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService memDao = new MemberServiceImpl();// 멤버 정보 수정
	private BoardService boDao = new BoardServiceImpl();// 게시글 수정

	private void title() {
		System.out.println("==================================");
		System.out.println("============ 사 용 자 메 뉴 =========");
		System.out.println("========  1. 나 의 정 보 수 정  ======");
		System.out.println("========  2. 게 시 글   보 기  ======");
		System.out.println("========  3. 게 시 글   작 성  ======");
		System.out.println("========  4. 게 시 글   수 정  ======");
		System.out.println("========  5. 종          료  ======");
		System.out.println("==================================");
	}

	private void userMenu(MemberVO vo) { // 0719
		System.out.println(vo.getName() + "님 환영합니다.");
		//메뉴가 동작 될 수 있도록 구현해 보세요.
		boolean b = false;
		do {
			title();
			int choice;
			switch(choice = sc.nextInt()) {
				case 1:
					memberUpdate();
					break;
				case 2:
					boardSelectList();
					break;
				case 3:
					boardInsert();
					break;
				case 4:
					boardUpdate(vo.getId());
					break;
				case 5:
					b=true;
					System.out.println("작업을 종료합니다.");
					break;
			}
		}while(!b);
	}
	

	private void boardUpdate(String id) {
		// TODO 자기 글 수정
		BoardVO vo = new BoardVO();
		System.out.println("게시글 수정하기");
		System.out.println("게시글 아이디를 입력하세요");
		String boardId = sc.next();sc.nextLine();
		vo.setBoardId(boardId);
		vo = boDao.boardSelect(vo); //아이디에 맞는 글을 선택한다.
		if(vo.getWriter().equals(id)) {
			vo = new BoardVO();
			System.out.println("내용을 입력하세요");
			vo.setSubject(sc.nextLine());
			vo.setWriter(id);
			vo.setBoardId(boardId);
			int n = boDao.boardUpdate(vo);
			if(n != 0) {
				System.out.println("정상적으로 수정되었습니다.");
			}else {
				System.out.println("글 수정이 실패 했습니다.");
			}
		}else {
			System.out.println("본인의 글만 수정 가능합니다.");
			vo.toString();
		}
		
	}

	private void memberUpdate() {
		// TODO 나의 정보 수정(주소와 전화번호만 수정 가능)
		MemberVO member = new MemberVO();
		System.out.println("새로운 주소를 입력하세요>>>  ");
		member.setAddress(sc.nextLine());sc.nextLine();
		System.out.println("새로운 전화번호를 입력하세요>>>  ");
		member.setTel(sc.next());sc.nextLine();
		System.out.println("나의 ID를 입력하세요>>>  ");
		member.setId(sc.next());sc.nextLine();
		int n = memDao.memberUpdate(member);
		if(n!=0) {
			System.out.println("정상적으로 수정되었습니다.");
		}else {
			System.out.println("정보 수정에 실패하였습니다.");
		}
	}

	private void boardSelectList() {
		// TODO 게시글 보기
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boDao.boardSelectList();
		for(BoardVO vo: list) {
			vo.toString();
		}
	}

	private void boardInsert() {
		// TODO 게시글 작성
		BoardVO vo = new BoardVO();
		System.out.println("게시글 아이디를 입력하세요>>>  ");
		vo.setBoardId(sc.next());sc.nextLine();
		System.out.println("글 제목을 입력하세요>>>  ");
		vo.setTitle(sc.next());sc.nextLine();
		System.out.println("글 내용을 입력하세요>>>  ");
		vo.setSubject(sc.nextLine());
		System.out.println("작성자를 입력하세요>>>  ");
		vo.setBoardId(sc.next());
		
		int n = boDao.boardInsert(vo);
		if(n!=0) {
			System.out.println("게시글이 작성되었습니다.");
		}else {
			System.out.println("게시글 작성이 실패했습니다.");
		}
		
	}

	public void run(MemberVO vo) {
		userMenu(vo);
	}
}
