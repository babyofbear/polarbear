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
	private ResultSet rs; // db 레코드 세트를 받는 것, 받을 그릇
	
	
	@Override
	public List<MemberVO> memberSelectList() { //전체리스트
		List<MemberVO> members = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); //받을 그릇-->rs
			while(rs.next()) { //종료가 명확하지 않을때 while 문 쓴다.
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
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
	public MemberVO memberSelect(MemberVO vo) { //한 명만 찾기
		String sql = "select * from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId()); //?에 값을 담는 다는 것(set은 (안의 값)을 집어 넣는것)
			rs = psmt.executeQuery();
			if(rs.next()) { //존재 하냐 안하냐
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setAge(rs.getInt("age"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// 데이터 삽입
		int n = 0;
		String sql = "insert into member values(?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getTel());
			psmt.setInt(6, vo.getAge());
			n = psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// 데이터 삭제
		int n = 0;
		String sql = "delete from member where id = ?";  //id가 유일한 key(PK=primary key)
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// 데이터 수정
		int n = 0;
		String sql = "update member set address = ?,tel=?,name=? where id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getAddress());
			psmt.setString(2, vo.getTel());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getId());
			n = psmt.executeUpdate();
		}catch(SQLException e ) {
			e.printStackTrace();
		}
		return n;
	}
	
}
