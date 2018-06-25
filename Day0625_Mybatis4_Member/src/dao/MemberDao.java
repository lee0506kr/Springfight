package dao;

import java.util.List;
import java.util.Map;

public interface MemberDao {
	public int insertMember(Map<String, Object> params);
	public int updateMember(Map<String, Object> params);
	public int deleteMember(String id);
	public Map<String, Object> selectOne(String id);
	public List<Map<String, Object>> selectAll();
}
