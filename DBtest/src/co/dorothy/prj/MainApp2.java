package co.dorothy.prj; //phase 2

import java.util.ArrayList;
import java.util.List;

import co.dorothy.prj.service.MemberService;
import co.dorothy.prj.serviceImpl.MemberServiceImpl;
import co.dorothy.prj.vo.MemberVO;

public class MainApp2 {

	public static void main(String[] args) {
		// DAO dao = new DAO();
		MemberService dao = new MemberServiceImpl(); //dao 역할
//		List<MemberVO> list = new ArrayList<MemberVO>();
//		
//		list = dao.memberSelectList();
		
		MemberVO vo = new MemberVO();
		vo.setId("park");
		
		vo = dao.memberSelect(vo);
		
//		for(MemberVO vo : list) {
			System.out.println(vo.getId());
			System.out.println(vo.getPassword());
			System.out.println(vo.getName());
			System.out.println(vo.getAddress());
			System.out.println(vo.getTel());
			System.out.println(vo.getAge());
			
//		}
		
//		toSting(list);

	}

}
