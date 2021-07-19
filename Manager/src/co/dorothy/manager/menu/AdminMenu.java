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

public class AdminMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService memDao = new MemberServiceImpl();// 멤버 정보 수정
	private BoardService boDao = new BoardServiceImpl();// 게시글 수정

	private void title() {
		System.out.println("==================================");
		System.out.println("=========== 관 리 자 메 뉴 ==========");
		System.out.println("======== 1. 사 용 자  관 리 =========");
		System.out.println("======== 2. 게 시 판  관 리 =========");
		System.out.println("======== 3. 종         료 =========");
		System.out.println("==================================");
		System.out.print("원하는 작업을 선택하세요>>>>>>  ");
	}

	private void subMemberTitle() {
		System.out.println("==================================");
		System.out.println("=========== 사 용 자 관 리 ==========");
		System.out.println("======== 1.멤 버 정 보 목 록 =========");
		System.out.println("======== 2.멤 버 정 보 조 회 =========");
		System.out.println("======== 3.멤 버 정 보 삭 제 =========");
		System.out.println("======== 4. 돌  아  가  기  =========");
		System.out.println("==================================");
		System.out.print("원하는 작업을 선택하세요>>>>>>  ");

	}

	private void subBoardTitle() {
		System.out.println("==================================");
		System.out.println("=========== 게 시 판 관 리 ==========");
		System.out.println("======== 1. 글   목   록   =========");
		System.out.println("======== 2. 글   쓰   기   =========");
		System.out.println("======== 3. 글   수   정   =========");
		System.out.println("======== 4. 글   삭   제   =========");
		System.out.println("======== 5. 돌  아  가  기  =========");
		System.out.println("==================================");
		System.out.print("원하는 작업을 선택하세요>>>>>>  ");

	}

	private void adminMenu(MemberVO vo) { // 0719
		System.out.println(vo.getName() + " 관리자님 환영합니다.");
		boolean b = false;
		do {
			title(); // 주 메뉴 출력
			int choise;
			switch (choise = sc.nextInt()) {
			case 1:
				userManager();
				break;
			case 2:
				boardManager();
				break;
			case 3:
				b = true;
				System.out.println("작업을 종료합니다.");
				break;
			}
		} while (!b);
	}

	private void boardManager() {
		// TODO 게시판 관리
		boolean b = false;
		do {
			int chk;
			subBoardTitle(); // 게시판 목록
			switch (chk = sc.nextInt()) {
			case 1:
				boardSelectList(); // 글 목록 보기
				break;
			case 2:
				boardInsert(); // 글 쓰기
				break;
			case 3:
				boardUpdate(); // 글 수정
				break;
			case 4:
				boardDelete(); // 글 삭제
				break;
			case 5:
				b = true;
				System.out.println("목록으로 돌아갑니다.");
				break;
			}
		} while (!b);
	}

	private void boardSelectList() {
		// TODO 글 목록 조회
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boDao.boardSelectList();
		for(BoardVO vo : list) {
			vo.toString();
		}
	}

	private void boardInsert() {
		// TODO 글 쓰기
		BoardVO vo = new BoardVO();
		System.out.print("게시판 아이디를 입력하세요>>>  ");
		vo.setBoardId(sc.next());sc.nextLine(); //next는 빈칸 나올때 까지 nextline은 enter 나올때까지
		System.out.print("글 제목을 입력하세요>>>  ");
		vo.setTitle(sc.nextLine());
		System.out.print("글 내용을 입력하세요>>>  ");
		vo.setSubject(sc.nextLine());
		System.out.print("작성자를 입력하세요>>>  ");
		vo.setWriter(sc.next());
		
		int n = boDao.boardInsert(vo);
		if(n!=0 ) {
			System.out.println("입력에 실패했습니다.");
		}else {
			System.out.println("정상적으로 입력되었습니다.");
		}
	}

	private void boardUpdate() {
		// TODO 글 수정 (내용만)
		BoardVO board = new BoardVO();
		System.out.println("수정할 글 번호를 입력하세요>>>  ");
		board.setBoardId(sc.next());sc.nextLine();
		System.out.println("새로운 글 내용을 입력하세요>>>");
		board.setSubject(sc.nextLine());
		int n = boDao.boardUpdate(board);
		if(n!=0) {
			System.out.println("정상적으로 수정되었습니다.");
		}else {
			System.out.println("수정에 실패하였습니다.");
		}

	}

	private void boardDelete() {
		// TODO 글 삭제
		BoardVO board = new BoardVO();
		System.out.println("삭제할 글 번호를 입력하세요>>>  ");
		board.setBoardId(sc.next());
		int n = boDao.boardDelete(board);
		if(n!=0) {
			System.out.println("정상적으로 삭제되었습니다.");
		}else {
			System.out.println("삭제되지 않았습니다.");
		}
	}

	private void userManager() {
		// TODO 사용자 관리
		boolean b = false;
		do {
			int chk;
			subMemberTitle(); // 사용자 메뉴 호출
			switch (chk = sc.nextInt()) {
			case 1:
				memberSelectList(); // 멤버 목록 조회
				break;
			case 2:
				sc.nextLine(); //버퍼 클리어??
				memberSelect();// 멤버 조회
				break;
			case 3:
				sc.nextLine();
				memberDelete(); // 멤버 삭제
				break;
			case 4:
				b = true;
				System.out.println("목록으로 돌아갑니다.");
				break;
			}
		} while (!b);
	}

	private void memberDelete() {
		// TODO 멤버 삭제
		MemberVO member = new MemberVO();
		System.out.println("삭제할 ID를 입력하세요>>>  ");
		member.setId(sc.nextLine());
		int n = memDao.memberDelete(member);
		if(n!=0) {
			System.out.println("정상적으로 삭제되었습니다.");
		}else {
			System.out.println("삭제되지 않았습니다.");
		}
	}

	private void memberSelect() {
		// TODO 멤버 조회
		MemberVO member = new MemberVO();
		System.out.print("검색할 ID를 입력하세요>>>  ");
		member.setId(sc.nextLine());
		member = memDao.MemberSelect(member);
		
		member.toString();
	}

	private void memberSelectList() {
		// TODO 멤버 목록 조회
		System.out.println("  <<<<사용자 목록>>>>   ");
		List<MemberVO> members = new ArrayList<MemberVO>();
		members = memDao.memberSelectList();
		for (MemberVO member : members) {
			member.toString();
		}
	}


	public void run(MemberVO vo) {
		adminMenu(vo);
	}

}
