package dao;

import java.util.List;
import java.util.Map;

import model.Member;

public interface IMemberDao {
	
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String id);
	public Member selectOne(String id);
	public List<Map<String, Object>> selectAll();

}
