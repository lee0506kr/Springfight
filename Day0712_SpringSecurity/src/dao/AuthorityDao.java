package dao;

import java.util.List;

public interface AuthorityDao {
	public List<String> selectUserAuthorities(String memberid);
}
