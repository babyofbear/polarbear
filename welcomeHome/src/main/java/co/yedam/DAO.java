package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class DAO {
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public void connect() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "demo";
		String password = "1234";
		
		try {
			//드라이버 로딩
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("connected!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
