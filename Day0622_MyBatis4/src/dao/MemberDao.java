package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Member;

public class MemberDao {

	SqlSessionFactory sqlSessionFactory;

	public MemberDao() {
		InputStream is = null;

		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int insertMember(Member member) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(MemberMapper.class).insertMember(member);
		} finally {
			session.close();
		}

	}

	public int updateMember(Member member) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(MemberMapper.class).updateMember(member);
		} finally {
			session.close();
		}
	}

	public int deleteMember(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(MemberMapper.class).deleteMember(id);
		} finally {
			session.close();
		}
	}

	public Member selectOne(String id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(MemberMapper.class).selectOne(id);
		} finally {
			session.close();
		}
	}

	public List<Member> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(MemberMapper.class).selectAll();
		} finally {
			session.close();
		}
	}

}
