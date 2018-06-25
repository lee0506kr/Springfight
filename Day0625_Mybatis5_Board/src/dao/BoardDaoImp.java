package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("boardDao")
public class BoardDaoImp implements BoardDao {

	@Autowired
	SqlSessionFactory sqlSessionFactory;

	@Override
	public int insertBoard(Map<String, Object> params) {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.getMapper(BoardDao.class).insertBoard(params);
		} finally {
			sqlSession.close();
		}

	}

	@Override
	public int updateBoard(Map<String, Object> params) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.getMapper(BoardDao.class).updateBoard(params);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public int deleteBoard(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.getMapper(BoardDao.class).deleteBoard(id);
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public Map<String, Object> selectOne(int num) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.getMapper(BoardDao.class).selectOne(num);
		} finally {
			sqlSession.close();
		}
		
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.getMapper(BoardDao.class).selectAll();
		} finally {
			sqlSession.close();
		}
	}

}
