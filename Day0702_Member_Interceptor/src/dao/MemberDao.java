package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String id);
	public Member selectOne(String id);
	public List<Member> selectAll();

}
