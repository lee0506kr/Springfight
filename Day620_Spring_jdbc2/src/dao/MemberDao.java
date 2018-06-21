package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Member;

public class MemberDao implements IMemberDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertMember(Member member) {

		String sql = "insert into member values(member_seq.nextval,?,?,?,?,sysdate)";

		return jdbcTemplate.update(sql, member.getId(), member.getPw(), member.getName(), member.getEmail());
	}

	@Override
	public int updateMember(Member member) {

		String sql = "update member set id =? ,name = ?  ,pw =?  , email = ? where = num";

		return jdbcTemplate.update(sql, member.getId(), member.getName(),member.getPw(), member.getEmail(), member.getNum());
	}

	@Override
	public int deleteMember(String id) {

		String sql = "delte from member where id = ?";

		return jdbcTemplate.update(sql, id);
	}

	@Override
	public Member selectOne(String id) {
		String sql = "select * from member where id =?";

		return jdbcTemplate.queryForObject(sql, memberMapper);
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		String sql = "select * from member";

		return jdbcTemplate.query(sql, memberMapper2);
	}

	RowMapper<Member> memberMapper = new RowMapper<Member>() {

		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {

			Member member = new Member();

			member.setNum(rs.getInt("num"));
			member.setId(rs.getString("id"));
			member.setEmail(rs.getString("email"));
			member.setName(rs.getString("name"));
			member.setPw(rs.getString("pw"));
			member.setRegdate(rs.getDate("reg_date"));

			return member;
		}
	};

	RowMapper<Map<String, Object>> memberMapper2 = new RowMapper<Map<String, Object>>() {

		@Override
		public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {

			Map<String, Object> result = new HashMap<String, Object>();

			result.put("num", rs.getInt("num"));
			result.put("id", rs.getString("id"));
			result.put("email", rs.getString("email"));
			result.put("name", rs.getString("name"));
			result.put("pw", rs.getString("pw"));
			result.put("regdate", rs.getDate("reg_date"));

			return result;
		}

	};

}
