package co.dorothy.board.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.dorothy.board.service.BoardService;
import co.dorothy.board.serviceImpl.BoardServiceImpl;
import co.dorothy.board.vo.BoardVO;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private BoardService dao = new BoardServiceImpl();

	private void menuTitle() {
		System.out.println("==============================");
		boardSelectList();
		System.out.println("==============================");
		System.out.println("======= 1. 글     조 회 ========");
		System.out.println("======= 2. 글     쓰 기 ========");
		System.out.println("======= 3. 글     삭 제 ========");
		System.out.println("===== 4. 종          료 =======");
		System.out.println("==============================");
		System.out.println("===== 원하는 작업을 선택하세요 ======");
		System.out.println("==============================");
	}

	private void mainMenu() {
		int selNo;
		boolean b = false;
		do {
			menuTitle();
			switch (selNo = sc.nextInt()){
			case 1:
				boardSelect() ;
				break;
			case 2:
				boardWrite();
				break;
			case 3:
				boardDelete();
				break;
			case 4:
				b = true;
				System.out.println("==============================");
				System.out.println("======== Good Bye! ===========");
				System.out.println("==============================");
				break;
			}
		} while (!b);
		
	}
	
	private void boardSelectList() {
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = dao.boardSelectList();
		for( BoardVO vo : boards) {
			vo.toString();
		}
	}

	private void boardWrite() { //글 쓰기
		BoardVO vo = new BoardVO();
		System.out.print("ID를 입력하세요>>> ");
		vo.setBoardId(sc.next());sc.nextLine();
		System.out.print("이름을 입력하세요>>> ");
		vo.setWriter(sc.next());sc.nextLine();
		System.out.print("제목을 입력하세요>>> ");
		vo.setTitle(sc.next());sc.nextLine();
		System.out.print("내용을 입력하세요>>> ");
		vo.setSubject(sc.nextLine());
		
		int n = dao.boardWrite(vo);
		if( n !=0) {
			System.out.println("입력이 완료되었습니다.");
		} else {
			System.out.println("입력되지 않았습니다.");
		}
		
	}
	private void boardDelete() { //글 삭제
		BoardVO vo = new BoardVO();
		System.out.print("삭제할 글 번호를 입력하세요>>> ");
		vo.setBoardId(sc.next());sc.nextLine();
		
		int n = dao.boardDelete(vo);
		if (n !=0 ) {
			System.out.println("선택한 글이 삭제되었습니다.");
		} else {
			System.out.println("삭제되지 않았습니다.");
		}
		
	}

	private void boardSelect() {
		BoardVO vo = new BoardVO();
		System.out.print("조회할 글 번호를 입력하세요>>>");
		vo.setBoardId(sc.next());sc.nextLine();
		vo = dao.boardVOSelect(vo);
		System.out.println(vo.getSubject());
		
		
	}
	
	public void run() {
		mainMenu();
		sc.close();
	}
}
