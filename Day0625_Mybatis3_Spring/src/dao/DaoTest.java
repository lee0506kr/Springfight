package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context
		 = new GenericXmlApplicationContext("dao/applicationContext.xml");
		
		
		StudentDao dao = context.getBean("studentDao",StudentDao.class);
		System.out.println(dao.selectAll());
		
		
		
	}

}
