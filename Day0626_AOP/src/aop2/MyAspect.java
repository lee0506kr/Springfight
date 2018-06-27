package aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	/* 공통 관심사항 모듈이 작성될 클래스  
	실제로 작성되는 내용(코드) >> advice
	advice의 종류 : 
	before : target  수행 전 실행될 코드
	after :  target  수행 후 실행될 코드
	after-returning : target이 정상적으로 종료 되면 실행될 코드 
	after-throwing :  target이 비정상적으로 종료되면 실행될 코드 
	around : target 앞뒤로 실행 될 코드를 정의
	
	지하철을 탑니다. 
	피시방에가서 게임을 합니다. 
	계산을 하고 집에 옵니다. 
	씻고 잠을 잡니다. 
	*
	*
	*
	*/
	public void before(JoinPoint jp) {
		//JoinPoint를 이용해서 Target 정보를 가져올 수 있다. 
		System.out.println("Target : " + jp.getTarget());
		System.out.println("지하철을 탑니다.");
	}
	public void after(JoinPoint jp) {
		//target 메서드  실행 후 
		//정상종료든, 비정상 종료든 항상 실행
		System.out.println("씻고 잠을 잔다.");
	}
	public void afterReturning(JoinPoint jp,String msg) {
		//target 메서드 정상종료 후
		System.out.println(msg+ " : 계산하고 집에 온다.");
	}
	public void afterThrowing(JoinPoint jp,Throwable th) {
		//target 메서드 비정상 종료 후
		System.out.println(th.getMessage() + " : 하던 일을 멈추고 집에 온다. ");
	}
	public void around(ProceedingJoinPoint jp) {
		//타겟메서드 실행 전후를 직접 관리
		//타겟메서드를 직접실행함 : 타겟에 접근할 수 있어야 한다. 
		try {
			before(jp);
			String msg = (String)jp.proceed(); //타겟 메서드 실행
			afterReturning(jp,msg);
		} catch (Throwable e) {
			e.printStackTrace();
			afterThrowing(jp,e);
		} finally {
			after(jp);
		}
	}
}










