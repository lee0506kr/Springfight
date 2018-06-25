package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Member;

public class MemberDaoImp implements MemberDao{
	private SqlSessionFactory sessionFactory;
	
	public MemberDaoImp() {
		InputStream is = null;
		
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sessionFactory
			 = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int insertMember(Member member) {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(MemberDao.class)
					.insertMember(member);
		}finally {
			session.close();
		}
	}

	@Override
	public int updateMember(Member member) {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(MemberDao.class).updateMember(member);
		}finally {
			session.close();
		}
	}

	@Override
	public int deleteMember(String id) {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(MemberDao.class)
					.deleteMember(id);
		}finally {
			session.close();
		}
	}

	@Override
	public Member selectOne(String id) {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(MemberDao.class)
					.selectOne(id);
		}finally {
			session.close();
		}
	}

	@Override
	public List<Member> selectAll() {
		SqlSession session = sessionFactory.openSession();
		try{
			return session.getMapper(MemberDao.class)
					.selectAll();
		}finally {
			session.close();
		}
	}
}









