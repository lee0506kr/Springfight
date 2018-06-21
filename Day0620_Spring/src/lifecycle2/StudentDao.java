package lifecycle2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class StudentDao {
	// 기능을 하기 위해서 연결이 필요함

	@Autowired
	private ConnectionProvider connectionProvider;

	private Connection connection;

	// DBMS와의 연결은 외부 자원을 이용하는 것이기 때문에 계속해서 열어 놓고 사용하면, 자원 누수가 발생
	// 사용할 때마다 연결을 만들어서 사용
	// 기능 : insert, update, delete, selectOne, selectAll

	public void setConnectionProvider(ConnectionProvider connectionProvider) {
		this.connectionProvider = connectionProvider;
	}

	/*
	 * public StudentDao(ConnectionProvider connectionProvider) {
	 * this.connectionProvider = connectionProvider; }
	 */
	@PostConstruct
	public void init() { //생성자 보다 나중에 실행된다.
		System.out.println("StudentDao 사용준비완료, 초기화작업");
	}

	@PreDestroy
	public void destory() {
		System.out.println("StudentDao 객체 소멸");
	}

	public void insertStudent(Student student) {

		PreparedStatement pstmt = null;
		try {
			// 연결얻어오기
			connection = connectionProvider.getConnection();

			String sql = "insert into student values(?,?,?)";
			pstmt = connection.prepareStatement(sql);

			pstmt.setInt(1, student.getSnum());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getSgrade());
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void updateStudent(Student student) {
		PreparedStatement pstmt = null;
		try {
			// 연결얻어오기
			connection = connectionProvider.getConnection();
			String sql = "update student " + "      set sname = ?," + "          sgrade = ?" + "    where snum = ?";
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, student.getSname());
			pstmt.setInt(2, student.getSgrade());
			pstmt.setInt(3, student.getSnum());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteStudent(int snum) {
		PreparedStatement pstmt = null;
		try {
			// 연결얻어오기
			connection = connectionProvider.getConnection();
			String sql = "delete from student where snum = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, snum);
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Student selectOne(int snum) {
		PreparedStatement pstmt = null;
		// 결과를 담아서 반환할 학생 참조변수
		Student student = null;
		ResultSet rs = null;

		try {
			// 연결얻어오기
			connection = connectionProvider.getConnection();
			String sql = "select * from student where snum = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, snum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				student = new Student();
				student.setSnum(rs.getInt("snum"));
				student.setSname(rs.getString("sname"));
				student.setSgrade(rs.getInt("sgrade"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return student;
	}

	public List<Student> selectAll() {
		PreparedStatement pstmt = null;
		// 결과를 담아서 반환할 학생 참조변수
		List<Student> studentList = new ArrayList<Student>();
		ResultSet rs = null;

		try {
			// 연결얻어오기
			connection = connectionProvider.getConnection();
			String sql = "select * from student";
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Student student = new Student();
				student.setSnum(rs.getInt("snum"));
				student.setSname(rs.getString("sname"));
				student.setSgrade(rs.getInt("sgrade"));
				studentList.add(student);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return studentList;
	}
}
