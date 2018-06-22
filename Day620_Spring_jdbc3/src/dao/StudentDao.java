package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Student;

public class StudentDao {
	SqlSessionFactory sqlSessionFactory;

	// SqlSession sqlSession;
	// sqlSession : DB접속, 자원관리, 예외처리 등의 역할
	// sqlSessionFactory : sqlSession을 얻어 옴
	public StudentDao() {
		// 설정파일 읽어와서, 해당 정보를 이용해서 factory 객체 생성
		// SqlSessionFactoryBuilder:factory 객체를 만들어주는 클래스
		// build(스트림:설정파일 내용을 담고 있는 스트림)
		InputStream is = null;

		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertStudent(Student student) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.insert("dao.studentMapper.insertStudent", student);
		} finally {
			session.close();
		}

	}

	public int updateStudent(Student student) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.update("dao.studentMapper.updateStudent", student);
		} finally {
			session.close();
		}

	}

	public int deleteStudent(int snum) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.delete("dao.studentMapper.deleteStudent", snum);
		} finally {
			session.close();
		}

	}

	public Student selectOne(int snum) {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.selectOne("dao.studentMapper.selectOne", snum);
		} finally {
			session.close();
		}

	}

	public List<Student> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();

		try {
			return session.selectList("dao.studentMapper.selectAll");
		} finally {
			session.close();
		}

	}

}
