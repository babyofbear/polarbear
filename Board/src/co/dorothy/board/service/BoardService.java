package co.dorothy.board.service;

import java.util.List;

import co.dorothy.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> BoardSelectList(); //전체 목록
	BoardVO boardVOSelect(BoardVO vo); //글 하나 목록
	int boardWrite(BoardVO vo); // 글 쓰기
	int boardDelete(BoardVO vo); // 글 삭제
//	int boardUpdate(BoardVO vo); // 조회수 증가

}
