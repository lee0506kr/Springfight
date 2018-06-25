package dao;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	public int insertBoard(Map<String, Object> params);
	public int updateBoard(Map<String, Object> params);
	public int deleteBoard(String id);
	public Map<String, Object> selectOne(int num);
	public List<Map<String, Object>> selectAll();

}
