package co.dorothy.prj.serviceImpl; //phase 5 (service 패키지 마우스오른쪽 interface 누르고 패키지이름 뒤에 
									//Impl 붙여넣고 아래에 extended interface <add> 눌러서 DAO 검색.
									// memberService 검색 (상속과 데이터 베이스 연결)

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dorothy.prj.DAO;
import co.dorothy.prj.service.MemberService;
import co.dorothy.prj.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt;  //데이터 베이스에 명령 전달
	private ResultSet rs; // 레코드 세트를 받는 것
	
	
	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getNString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAge(rs.getInt("age"));
				members.add(vo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return members;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
