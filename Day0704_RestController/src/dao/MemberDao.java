package dao;

import java.util.List;
import java.util.Map;

public interface MemberDao {
	
	public int insertMember(Map<String , Object> member);
	public int updateMember(Map<String , Object> member);
	public int deleteMember(String id);
	public Map<String, Object> slectOne(String id);
	public List<Map<String, Object>> selectAll();
	

}
