package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import service.MemberService;

public class MemberTest {
	public static void main(String[] args) {
		//서비스 객체가 제대로 만들어 졌는지 테스트 한다. 
		//스프링 컨테이너 에서 service 객체 가져와서 테스트 
		
		ApplicationContext context
		 = new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService service 
		= context.getBean("memberServiceImp",MemberService.class);
		
		System.out.println(service.getAllMember());
		
		
		
		
		
		
	}
}
