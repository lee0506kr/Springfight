package dao3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Board;

public class BoardTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao3/applicationContext.xml");

	IBoardDao dao = context.getBean("boardDao",IBoardDao.class);
		
		Board board = new Board();
		board.setNum(41);
		board.setTitle("스프링입니다. ");
		board.setName("홍길동동동동동");
		board.setPass("12311");
		board.setEmail("hong@email.honghong.com");
		board.setContent("으아아아아아아아아아아");
//		dao.insertBoard(board);
		dao.updaetBoard(board);
		System.out.println("종료");
		

	}

}
