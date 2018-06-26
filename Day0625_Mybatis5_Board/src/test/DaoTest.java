package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import dao.BoardDao;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context 
		  = new GenericXmlApplicationContext("dao/applicationContext.xml");
		
		BoardDao dao = context.getBean("boardDao",BoardDao.class);
		
//		Map<String, Object> board = new HashMap<String,Object>();
		
//		board.put("TITLE","제목입니다.");
//		board.put("NAME","김갑동");
//		board.put("PASS","123");
//		board.put("EMAIL","gapdong@email.com");
//		board.put("CONTENT","내용입니다. 내용 내용 내용 내용 내용 내용");
//		dao.insertBoard(board);
		
		Map<String, Object> params = new HashMap<String,Object>();
		
//		0. 검색 하지 않음, 전체 선택
//		1. 제목검색        title
//		2. 이름검색        name
//		3. 제목+이름검색     title, name
//		4. 내용검색  content
		
		params.put("type", 0);
		//params.put("TITLE", "스프링");
		
		
		List<Map<String, Object>> result
		 = dao.searchBoard(params);
		
		for(Map<String, Object> board :result) {
			System.out.println("TITLE : " + board.get("TITLE"));
			System.out.println("NAME : " + board.get("NAME"));
			System.out.println("CONTENT : " + board.get("CONTENT"));
			System.out.println("WRITEDATE : " + board.get("WRITEDATE"));
			System.out.println("-----------------------------------");
			
		}
		
		
		
		
		
		
		
		
		System.out.println("종료 ");
		
	}
}
