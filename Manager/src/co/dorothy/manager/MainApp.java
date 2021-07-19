package co.dorothy.manager;

import java.util.ArrayList;
import java.util.List;

import co.dorothy.manager.member.service.MemberService;
import co.dorothy.manager.member.serviceImpl.MemberServiceImpl;
import co.dorothy.manager.member.vo.MemberVO;
import co.dorothy.manager.menu.LoginMenu;

public class MainApp {

	public static void main(String[] args) {
		LoginMenu menu = new LoginMenu();
		menu.login();
		
		
		
		
		
//		MemberService memberDao = new MemberServiceImpl();
//		List<MemberVO> members = new ArrayList<MemberVO>();
//		members = memberDao.memberSelectList();
//		for(MemberVO vo : members) {
//			vo.toString();
//		}
		// 한 명 불러오기
	}
}
