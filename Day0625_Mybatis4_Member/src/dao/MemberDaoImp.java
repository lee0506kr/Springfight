package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("memberDao") 
public class MemberDaoImp implements MemberDao{
   
   @Autowired
   SqlSessionFactory sqlSessionFactory;

   @Override
   public int insertMember(Map<String, Object> params) {
      SqlSession sqlSession 
      = sqlSessionFactory.openSession();
      
      try{
         return sqlSession.getMapper(MemberDao.class).insertMember(params);
      }finally {
         sqlSession.close();
      }
   }

   @Override
   public int updateMember(Map<String, Object> params) {
      SqlSession sqlSession 
      = sqlSessionFactory.openSession();
      
      try{
         return sqlSession.getMapper(MemberDao.class).updateMember(params);
      }finally {
         sqlSession.close();
      }
   }

   @Override
   public int deleteMember(String id) {
      SqlSession sqlSession 
      = sqlSessionFactory.openSession();
      
      try{
         return sqlSession.getMapper(MemberDao.class).deleteMember(id);
      }finally {
         sqlSession.close();
      }
   }

   @Override
   public Map<String, Object> selectOne(String id) {
      SqlSession sqlSession 
      = sqlSessionFactory.openSession();
      
      try{
         return sqlSession.getMapper(MemberDao.class).selectOne(id);
      }finally {
         sqlSession.close();
      }
   }

   @Override
   public List<Map<String, Object>> selectAll() {
      SqlSession sqlSession 
      = sqlSessionFactory.openSession();
      
      try{
         return sqlSession.getMapper(MemberDao.class).selectAll();
      }finally {
         sqlSession.close();
      }
   }
   
}