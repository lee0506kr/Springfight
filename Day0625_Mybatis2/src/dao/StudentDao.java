package dao;

import java.util.List;
import java.util.Map;


public interface StudentDao {

	public int insertStudent(Map<String, Object> param);

	public int updateStudent(Map<String, Object> param);

	public int deleteStudent(int snum);

	public Map<String, Object> selectOne(int snum);

	public List<Map<String, Object>> selectAll();

}
