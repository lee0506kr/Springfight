package dao;

import model.Student;

public class StudentTest {
	public static void main(String[] args) {
		
		StudentDao dao = new StudentDao();
		
		Student student = new Student();
		
//		student.setSnum(3);
//		student.setSname("신사임당");
//		student.setSgrade(3);
//		
//		dao.insertStudent(student);
		

		for(Student s : dao.selectAll()) {
			System.out.println(s);
		}
		
		
		
		System.out.println("종료");
		
	}
}
