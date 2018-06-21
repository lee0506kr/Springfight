package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Student;

public class StudentDao implements IStudentDao {
	// 드라이버 로딩 : spring
	// 연결생성 : spring
	// DB 연결 속성(url,username,password) 지정: 개발자
	// 연결 생성 : spring
	// 구문객체생성 : spring
	// 실행 sql : 작성 : 개발자
	// sql 실행 : spring
	// 결과 처리 : 개발자

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertStudent(Student student) {
		String sql = "insert into student_ex values(?,?,?)";
		// javaJDBC에서 실행 메서드 : executeQuery , excuteUpdate

		// jdbcTemplate.update(sql,val1,val2,val3);
		return jdbcTemplate.update(sql, student.getSnum(), student.getSname(), student.getSgrade());
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update student_ex set sname = ? , sgrade =  ? where snum = ?";
		
		return jdbcTemplate.update(sql, student.getSnum(), student.getSname(), student.getSgrade());
	}

	@Override
	public int deleteStudent(int snum) {
		String sql = "delete from student_ex where snum = ?";
		
		return jdbcTemplate.update(sql,snum);
	}

	@Override
	public Student selectOne(int snum) {
		
		String sql = "select * from student_ex where snum=?";
		
		//jdbcTemplate.query(sql,결과 처리를 위한 Mapper, 파라미);
		
		
		
		return jdbcTemplate.queryForObject(sql,studentMapper ,snum);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from student_ex";
		return jdbcTemplate.query(sql,studentMapper2);
	}

	//Mapper : 조회한 결과를 결과 모델객체에 넣을 때, 어떤 칼럼의 값을 어떤 필드에 넣을건지 지
	//		: 익명 클래스 작성해서 칼럼과 모델 프러퍼티 매핑 작업해야 한다.
	RowMapper<Student> studentMapper = new RowMapper<Student>() {
		
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Student student = new Student();
			
			student.setSnum(rs.getInt("snum"));
			student.setSname(rs.getString("sname"));
			student.setSgrade(rs.getInt("sgrade"));
			
			return student;
		}
	};
	
	RowMapper<Map<String, Object>> studentMapper2
	= new RowMapper<Map<String,Object>>() {
		
		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Map<String, Object> result = new HashMap<String , Object>();
			result.put("snum",rs.getInt("snum"));
			result.put("sname",rs.getString("sname"));
			result.put("sgrade",rs.getInt("sgrade"));
			
			return result;
		}
	};
	
	
	
}
