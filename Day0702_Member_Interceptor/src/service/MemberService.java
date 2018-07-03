package service;

import java.util.List;

import model.Member;

public interface MemberService {
	
	public boolean login(String id,String pw);
	public Member getMemberById(String id);
	public boolean join(Member member);
	public List<Member> selectAll();
}
