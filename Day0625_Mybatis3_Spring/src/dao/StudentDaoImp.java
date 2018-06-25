package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Student;

public class StudentDaoImp implements StudentDao {

	private SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public int insertStudent(Student student) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.getMapper(StudentDao.class).insertStudent(student);
		} finally {
			session.close();
		}

	}

	@Override
	public int updateStudent(Student student) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.getMapper(StudentDao.class).updateStudent(student);
		} finally {
			session.close();
		}
	}

	@Override
	public int deleteStudent(int snum) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.getMapper(StudentDao.class).deleteStudent(snum);
		} finally {
			session.close();
		}
	}

	@Override
	public Student selectOne(int snum) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.getMapper(StudentDao.class).selectOne(snum);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Student> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.getMapper(StudentDao.class).selectAll();
		} finally {
			session.close();
		}
	}

}
