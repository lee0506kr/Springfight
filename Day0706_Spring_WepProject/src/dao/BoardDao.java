package dao;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	/* dao에서 구현하고자 하는 메서드 선언*/
	public int insertBoard(Map<String, Object> board);
	public int updateBoard(Map<String, Object> board);
	public int deleteBoard(int num);
	
	
	public Map<String, Object> selectOne(int num);
	
	
	
	public List<Map<String, Object>> selectAll();
	public List<Map<String, Object>> searchBoard(Map<String, Object> board);
	public int updateReadCount(int num);
	public int selectCount();
	public List<Map<String, Object>> selectList(Map<String, Object> board);


}
