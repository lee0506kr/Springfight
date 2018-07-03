package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.MemberDao;
import model.Member;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/spring/root-context.xml")
public class DaoTest {
		
	@Autowired
	private MemberDao dao;

	@Test
	public void memberDaoTest() {
		
		Member member = new Member();
		member.setId("id10");
		member.setName("테스트");
		member.setPw("123");
		member.setEmail("id10@naver.com");
		
		dao.insertMember(member);
		
		
	}
}
