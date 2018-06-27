package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MemberAspect {
	
	//log4j를 이용한 출력 : logger 객체를 활용
	private static final Logger logger 
	       = Logger.getLogger(MemberAspect.class);
	
	
	//모든 service 패키지에 있는 'ServiceImp'로 끝나는 이름을 가지는 클래스에 선언된
	//서비스 메서드에 aop 적용
	@Pointcut("execution(* service.*ServiceImp.*(..))")
	public void servicept() {} 
	
	@Before("servicept()")
	public void startService() {
//		System.out.println("======서비스 시작합니다=======");
		logger.debug("DEBUG : =====서비스 시작합니다 =======");
		logger.info("INFO : =======서비스 시작합니다 =======");
	}
	@After("servicept()")
	public void endService() {
//		System.out.println("======서비스 종료합니다=======");
		logger.debug("DEBUG : =====서비스 종료합니다 =======");
		logger.info("INFO : =======서비스 종료합니다 =======");
	}
}
