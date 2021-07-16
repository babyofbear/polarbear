package co.dorothy.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao { //static class로 만들었다.ㅣ
	public static Connection getConnection() {
		Connection conn = null;
		String diver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "demo";
		String password = "1234";
		
		try {
			Class.forName(diver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
