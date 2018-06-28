package dao;

import java.util.List;

import model.Student;

public interface StudentDao {
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int num);
	public Student selectOne(int num);
	public List<Student> selectAll();
}
