package dao;

import model.Member;

public class DaoTest {
	public static void main(String[] args) {
		MemberDaoImp memberDao = new MemberDaoImp();
		
		Member member = new Member();
		member.setId("id2");
		member.setPw("123");
		member.setName("손흥민");
		member.setEmail("jang@email.com");
		
//		memberDao.insertMember(member);
//		memberDao.updateMember(member);
//		memberDao.deleteMember("id2");
//		System.out.println(memberDao.selectOne("id1"));
	
		System.out.println(memberDao.selectAll());
		
		
		System.out.println("종료");
		
		
		
		
		
		
		
		
		
	}
}
