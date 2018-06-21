package dao2;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context 
		 = new GenericXmlApplicationContext("dao2/applicationContext.xml");
		MessageDao dao = context.getBean("messageDao",MessageDao.class);
		
		
//		Map<String, Object> result = dao.selectOne(49);
		
		
//		System.out.println("아이디 : " + result.get("id"));
//		System.out.println("비번  : " + result.get("password"));
//		System.out.println("이름 : " + result.get("name"));
//		System.out.println("메시지 : " + result.get("message"));
//		System.out.println("--------------------------------");
		
		List<Map<String, Object>> messageList 
		 = dao.selectAll();
		
		for(Map<String, Object> message :messageList) {
			System.out.println("아이디 : " + message.get("id"));
			System.out.println("비번  : " + message.get("password"));
			System.out.println("이름 : " + message.get("name"));
			System.out.println("메시지 : " + message.get("message"));
			System.out.println("--------------------------------");
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}
