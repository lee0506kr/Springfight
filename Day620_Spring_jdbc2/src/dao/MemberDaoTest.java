package dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Member;

public class MemberDaoTest {
	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("dao/applicationContext.xml");

		IMemberDao dao = context.getBean("memberDao", IMemberDao.class);

/*		List<Map<String, Object>> memberList = dao.selectAll();

		for (Map<String, Object> member : memberList) {

			System.out.println("번호: " + member.get("num"));
			System.out.println("아이디: " + member.get("id"));
			System.out.println("비밀번호: " + member.get("pw"));
			System.out.println("닉네임: " + member.get("name"));
			System.out.println("------------------------------");
		};*/


	
		Member member = new Member();
		
		member.setId("ieeeee");
		member.setName("우왕");
		member.setEmail("qwe@naver1111.com");
		member.setPw("1234");
		
		
		dao.insertMember(member);
		
		
		
	
	
	
	}
	
	
	
}
