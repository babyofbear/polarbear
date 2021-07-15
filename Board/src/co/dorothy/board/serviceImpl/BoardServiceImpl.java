package co.dorothy.board.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dorothy.board.DAO.DAO;
import co.dorothy.board.service.BoardService;
import co.dorothy.board.vo.BoardVO;

public class BoardServiceImpl extends DAO implements BoardService {
	private PreparedStatement psmt; //데이터 베이스에서 명령 전달
	private ResultSet rs; //db 레코드 세트를 받는 그릇
	

	@Override
	public List<BoardVO> boardSelectList() { //전체 목록
		List<BoardVO> boards = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "select * from boardid";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBoardId(rs.getString("boardid"));
				vo.setWriter(rs.getString("writer"));
				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));
				vo.setEnterDate(rs.getDate("date"));
				vo.setHit(rs.getInt("hit"));
				boards.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boards;
	}

	@Override
	public BoardVO boardVOSelect(BoardVO vo) { //글 조회
		String sql = "select subject from board where boardid =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardId());
			rs = psmt.executeQuery();
			if(rs.next()) {
//				vo.setBoardId(rs.getString("boardid"));
//				vo.setWriter(rs.getString("writer"));
//				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));
//				vo.setEnterDate(rs.getDate("date"));
				vo.setHit(rs.getInt("hit")+1);
				hitUpdate(vo.getBoardId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int boardWrite(BoardVO vo) { // 글 쓰기
		int n = 0;
		String sql = "insert into board(boardid,writer,title,subject) values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardId());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getTitle());
			psmt.setString(4, vo.getSubject());
			psmt.setDate(5, vo.getEnterDate());
			psmt.setInt(6, vo.getHit());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) { //글 삭제
		int n = 0;
		String sql = "delete from board where boardid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardId());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	private void hitUpdate(String boardId) { //조회수 한번 늘리기
		String sql = "update board set hit = hit + 1 where boardid =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, boardId);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
//	@Override
//	public int boardUpdate(BoardVO vo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
