package lifecycle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	//DBMS와의 연결을 제공해주는 클래스
	//얘가 해야 되는 기능 : 연결 반환, 클래스 변스(상수 변수를 이용해서 같은 작업을 하기 때문에, 객체마다 생성될 필요가 없다: static 선언)
	//연결을 만들어 내기 위해서 필요한 상태값: url, user, password
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER= "lee5656kr";
	private static final String PASSWORD = "qwer4512";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//1. 드라이버 로딩,
		//2. 연결 하고, 반환
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
}
