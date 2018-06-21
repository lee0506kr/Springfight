package di03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext("di03/applicationContext.xml");

		Car myCar = context.getBean("myCar", Car.class);
		myCar.drive();

	}

}
