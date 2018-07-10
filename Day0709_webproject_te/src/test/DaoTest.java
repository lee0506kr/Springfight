package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.BoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:WebContent/WEB-INF/spring/root-context.xml"})
public class DaoTest {
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void boardDaoTest() {
		Map<String, Object> params = new HashMap<String,Object>();
//		params.put("TITLE", "제목");
		params.put("type", 0);
		params.put("firstRow", 11);
		params.put("endRow", 20);
		
		List<Map<String, Object>> boardList
		 = boardDao.searchBoard(params);
		
		for(Map<String, Object> board:boardList) {
			System.out.println(board);
		}
		
		
		
		
		
	}
	
}










