package dao;

import java.util.List;
import java.util.Map;
import model.Student;

public interface IStudentDao {
	
	public int insertStudent(Student student);

	public int updateStudent(Student student);

	public int deleteStudent(int snum);

	public Student selectOne(int snum);

	public List<Map<String, Object>> selectAll();
}
