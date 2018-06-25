package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MessageDao {
	SqlSessionFactory sqlSessionFactory;
	
	public MessageDao() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int insertMessage(Map<String, Object> param) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.insert("dao.messageMapper.insertMessage",param);
		}finally {
			sqlSession.close();
		}
	}
	public int updateMessage(Map<String, Object> param) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.update("dao.messageMapper.updateMessage",param);
		}finally {
			sqlSession.close();
		}
	}
	public int deleteMessage(int num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.delete("dao.messageMapper.deleteMessage",num);
		}finally {
			sqlSession.close();
		}
	}
	public Map<String, Object> selectOne(int num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectOne("dao.messageMapper.selectOne",num);
		}finally {
			sqlSession.close();
		}
	}
	public List<Map<String, Object>> selectAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			return sqlSession.selectList("dao.messageMapper.selectAll");
		}finally {
			sqlSession.close();
		}
	}
}
