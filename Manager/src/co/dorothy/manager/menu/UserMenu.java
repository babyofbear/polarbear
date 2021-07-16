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
	private MemberService memDao = new MemberServiceImpl();//멤버 정보 수정
	private BoardService boDao = new BoardServiceImpl();//게시글 수정

	private void title() {
		System.out.println("==================================");
		System.out.println("=========== 사 용 자 메 뉴 ==========");
		System.out.println("==================================");
	}

	private void userMenu(MemberVO vo) {
		System.out.println(vo.getName() + "님 환영합니다.");
		title();
		boardList();
	}

	private void boardList() {
		// TODO 게시판 목록 보기
		List<BoardVO> list = new ArrayList<BoardVO>();
		list = boDao.boardSelectList();
		for(BoardVO vo : list) {
			vo.toString();
		}
		
	}

	public void run(MemberVO vo) {
		userMenu(vo);
	}
}
