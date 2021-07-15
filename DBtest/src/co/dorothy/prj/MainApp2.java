package co.dorothy.prj;

import co.dorothy.prj.app.Menu;

//phase 2

//import java.util.ArrayList;
//import java.util.List;
//
//import co.dorothy.prj.service.MemberService;
//import co.dorothy.prj.serviceImpl.MemberServiceImpl;
//import co.dorothy.prj.vo.MemberVO;

public class MainApp2 {

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.run();
	}
//	public static void main(String[] args) {
////		 DAO dao = new DAO();
//		MemberService dao = new MemberServiceImpl(); //dao 역할
//		List<MemberVO> list = new ArrayList<MemberVO>();
//		
//		list = dao.memberSelectList();//전체 목록 
//		for(MemberVO vo : list) {
//			System.out.println(vo.toString());
//		}
		

//		MemberVO vo = new MemberVO(); //목록 삽입
//		vo.setId("park2");
//		vo.setName("도로시");
//		vo.setAddress("");
//		vo.setTel("111-555-5555");
		
//		int n = dao.memberInsert(vo); //목록 삽입
//		if(n != 0) {
//			System.out.println("정상적으로 입력되었습니다.");
//		} else {
//			System.out.println("입력이 실패했습니다.");
//		}
		
		
//		int n = dao.memberDelete(vo); //목록 삭제
//		if(n != 0) {
//			System.out.println("정상적으로 삭제되었습니다.");
//		} else {
//			System.out.println("입력이 실패했습니다.");
//		}
		
//		int n = dao.memberUpdate(vo); //목록 수정
//		if(n != 0) {
//			System.out.println("정상적으로 수정되었습니다.");
//		} else {
//			System.out.println("수정이 실패했습니다.");
//		}
		
//		vo = dao.memberSelect(vo);
		
		
	}


