package aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext context
		 = new GenericXmlApplicationContext("aop2/applicationContext.xml");
		//boy.doSomething();
		Person boy= context.getBean("boy", Person.class); 
		boy.doSomething();
	}
}
