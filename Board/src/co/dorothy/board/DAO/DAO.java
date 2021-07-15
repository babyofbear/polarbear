package co.dorothy.board.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import co.dorothy.board.vo.BoardVO;

public class DAO {
	public Connection conn; //연결객체
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "demo";
	private String password = "1234";
	
	public DAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

//	public List<BoardVO> BoardSelectList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public BoardVO boardVOSelect(BoardVO vo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public int boardWrite(BoardVO vo) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//}
