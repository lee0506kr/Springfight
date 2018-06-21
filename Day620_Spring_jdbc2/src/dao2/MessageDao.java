package dao2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component("messageDao")
public class MessageDao implements IMessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	 */
	@Override
	public int insertMessage(Map<String, Object> param) {

		String sql = "insert into message values(message_seq.nextval,?,?,?)";

		return jdbcTemplate.update(sql, param.get("name"), param.get("message"), param.get("password"));
	}

	@Override
	public int updateMessage(Map<String, Object> param) {
		String sql = "update message set password =? , name =?, message=?, where = id ";

		return jdbcTemplate.update(sql, param.get("id"), param.get("name"), param.get("message"),
				param.get("password"));

	}

	@Override
	public int deleteMessage(int id) {
		String sql = "delte from message where id = ?";

		return jdbcTemplate.update(sql, id);
	}

	@Override
	public Map<String, Object> selectOne(int id) {
		String sql = "select * from message where id =?";

		return jdbcTemplate.queryForMap(sql,id);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from message";

		return jdbcTemplate.queryForList(sql);
	}

	
	/*RowMapper<Map<String, Object>> messageMapper = new RowMapper<Map<String, Object>>() {

		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Map<String, Object> result = new HashMap<String, Object>();
			
			result.put("id", rs.getInt("id"));
			result.put("password",rs.getString("password"));
			result.put("name", rs.getString("name"));
			result.put("message", rs.getString("message"));
			
			
			return result;
		}
	};*/

	/*RowMapper<Map<String, Object>> messageMapper2 = new RowMapper<Map<String, Object>>() {

		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {

			Map<String, Object> result = new HashMap<String, Object>();

			result.put("id", rs.getString("id"));
			result.put("name", rs.getString("name"));
			result.put("message", rs.getString("message"));
			result.put("password", rs.getString("password"));

			return result;
		}
	};
*/
}
