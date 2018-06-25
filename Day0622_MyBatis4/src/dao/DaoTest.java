package dao;

import model.Member;


public class DaoTest {
	public static void main(String[] args) {
		
		
		
		Member member = new Member();
		
		MemberDao dao = new MemberDao();
		
		
		member= dao.selectOne("qwe");
		
		System.out.println(member);
		
		/*for(Member s1 : dao.selectAll()) {
			System.out.println(s1);
		}*/
		
		
	}
}
