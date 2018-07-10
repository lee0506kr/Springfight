package service;

import java.util.List;
import java.util.Map;

public interface MemberService {
	
	public boolean login(String id, String pw);
	public Map<String , Object>  getMemberById(String id);
	public boolean join(Map<String , Object> member);
	public List<Map<String , Object>> selectAll();
	public boolean modifyMember(Map<String,Object> member);
	
}
