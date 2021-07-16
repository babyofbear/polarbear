package co.dorothy.manager.board.serviceImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.dorothy.manager.Dao;
import co.dorothy.manager.board.service.BoardService;
import co.dorothy.manager.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	private Connection conn = Dao.getConnection();
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> boardSelectList() {
		// TODO 게시판 목록
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "select * from board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBoardId(rs.getString("boardid"));
				vo.setWriter(rs.getString("Writer"));
				vo.setTitle(rs.getString("title"));
				vo.setEnterDate(rs.getDate("enterdate"));
				vo.setHit(rs.getInt("hit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		// TODO 게시글 조회
		String sql = "select * from board where boardid =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBoardId(rs.getString("boardid"));
				vo.setWriter(rs.getString("Writer"));
				vo.setTitle(rs.getString("title"));
				vo.setSubject(rs.getString("subject"));
				vo.setEnterDate(rs.getDate("enterdate"));
				vo.setHit(rs.getInt("hit"));
				updateHit(vo.getBoardId()); //조회수 증가 메소드
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	private void updateHit(String boardId) {
		// TODO 조회수 증가 메소드
		String sql = "update board set hit = hit + 1 where id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, boardId);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
