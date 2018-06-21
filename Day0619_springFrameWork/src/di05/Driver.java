package di05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		
		
		//스프링컨테이너 로딩
		ApplicationContext context = new GenericXmlApplicationContext("di05/applicationContext.xml");

		Car myCar = context.getBean("car", Car.class);
		myCar.drive();

	}

}
