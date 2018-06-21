package dao3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import model.Board;

@Component
public class BoardDao implements IBoardDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int insertBoard(Board board) {
		// sql 변수 부분에 파라미터 map의 키값을 :key 형태로 작성
		String sql = "insert into board1 values" + " (board1_seq.nextval,:title,:name,:pass,:email,:content,0,sysdate)";
		// sql에 들어갈 변수와 값을 key-value 매핑으로 정의
		// >>map을 이용해서 변수 설정
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("title", board.getTitle());
		params.put("email", board.getEmail());
		params.put("content", board.getContent());
		params.put("pass", board.getPass());
		params.put("name", board.getName());

		return jdbcTemplate.update(sql, params);
	}

	@Override
	public int updaetBoard(Board board) {
		String sql = "update board1" + "   set title = :title," + "       content = :content," + "       pass = :pass,"
				+ "       name = :name" + "   where num = :num";
		// 좀 더 쉽게 파라미터 map을 만들 수 있음
		// 자바 빈의 멤버를 map으로 변환해주는 클래스
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(board);
		return jdbcTemplate.update(sql, params);

	}

	@Override
	public int deleteBoard(int num) {
		String sql = "delete from board1 where num = :num";
		// 파라미터가 하나인 경우 사용할 수 있는 map
		return jdbcTemplate.update(sql, Collections.singletonMap("num", num));
	}

	@Override
	public Board selectOne(int num) {
		String sql = "select * from board1 where num = :num";
		// 스프링에서 제공하는 클래스
		MapSqlParameterSource param = new MapSqlParameterSource("num", num);
		// jdbcTemplate.queryForObject(sql, param, requiredType);

		return jdbcTemplate.queryForObject(sql, param, boardMapper);
	}

	@Override
	public List<Board> selectAll() {
		String sql = "select * from board1";

		
		
		return jdbcTemplate.query(sql, boardMapper);

	}

	RowMapper<Board> boardMapper = new RowMapper<Board>() {

		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			Board board = new Board();
			board.setNum(rs.getInt("num"));
			board.setTitle(rs.getString("title"));
			board.setName(rs.getString("name"));
			board.setPass(rs.getString("pass"));
			board.setEmail(rs.getString("email"));
			board.setContent(rs.getString("content"));
			board.setReadCount(rs.getInt("readcount"));
			board.setWriteDate(rs.getDate("writedate"));
			return board;
		}
	};

}
