package co.dorothy.manager.member.service;

import java.util.List;

import co.dorothy.manager.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList() ;
		
		MemberVO MemberSelect(MemberVO vo);
		MemberVO loginCheck(MemberVO vo);
		int memberInsert(MemberVO vo);
		int memberDelete(MemberVO vo);
		int memberUpdate(MemberVO vo);
		
		

	}


