package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberDao2")
public class MemberDaoImp2 implements MemberDao {

	@Autowired
	SqlSession sqlSession;
	
//	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
//	
	@Override
	public int insertMember(Map<String, Object> params) {
		return sqlSession.getMapper(MemberDao.class).insertMember(params);
	}

	@Override
	public int updateMember(Map<String, Object> params) {
		return sqlSession.getMapper(MemberDao.class).updateMember(params);
	}

	@Override
	public int deleteMember(String id) {
		return sqlSession.getMapper(MemberDao.class).deleteMember(id);
	}

	@Override
	public Map<String, Object> selectOne(String id) {
		return sqlSession.getMapper(MemberDao.class).selectOne(id);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		return sqlSession.getMapper(MemberDao.class).selectAll();
	}

}
