package robot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RobotTest {
	public static void main(String[] args) {
		ApplicationContext context
		 = new GenericXmlApplicationContext("robot/applicationContext.xml");
		
		
		//Robot r1 = context.getBean("gundam",Robot.class);
		Robot r2 = context.getBean("transformer",Robot.class);
	
		//r1.fight();
		r2.fight();
	}
}






