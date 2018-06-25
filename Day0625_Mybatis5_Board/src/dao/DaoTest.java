package dao;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import common.Constant;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context
		 = new GenericXmlApplicationContext("dao/applicationContext.xml");
		
		BoardDao dao 
		= context.getBean("boardDao",BoardDao.class);
		
		Map<String, Object> board = dao.selectOne(1);
		
		System.out.println("제목 : " + board.get(Constant.Member.TITLE));
		System.out.println("이름 : " + board.get(Constant.Member.NAME));
		System.out.println("이메일 : " + board.get(Constant.Member.EMAIL));
		
		
	}
}
