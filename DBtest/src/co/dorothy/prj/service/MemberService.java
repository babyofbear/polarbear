package co.dorothy.prj.service; //phase 4 (vo 패키지 위에서 마우스 우 클릭 뉴, 인터페이스)

import java.util.List;

import co.dorothy.prj.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList(); //전체 리스트 가져오기
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	
}
