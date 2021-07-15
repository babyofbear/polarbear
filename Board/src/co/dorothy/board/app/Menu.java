package co.dorothy.board.app;

import java.util.Scanner;

import co.dorothy.board.service.BoardService;
import co.dorothy.board.serviceImpl.BoardServiceImpl;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private BoardService dao = new BoardServiceImpl();

	private void menuTitle() {
		System.out.println("==============================");
		System.out.println("======  자  유  게  시  판  =====");
		System.out.println("======= 1. 글     조 회 ========");
		System.out.println("======= 2. 글     쓰 기 ========");
		System.out.println("======= 3. 글     삭 제 ========");
		System.out.println("===== 4. 종          료 ========");
		System.out.println("==============================");
		System.out.println("=====  원하는 작업을 선택하세요 =====");
	}

	private void mainMenu() {
		int selNo;
		boolean b = false;

		do {

		} while (!b);
		{

		}

	}
}
