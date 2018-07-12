package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	public List<Member> selectAll();
	public Member selectOne(String id);
	public int insertMember(Member member);
}
