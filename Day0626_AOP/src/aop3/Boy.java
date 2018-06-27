package aop3;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Boy implements Person{
	public String doSomething() throws Exception {
		System.out.println("피시방을 가서 게임을 한다.");
		//랜덤하게 예외를 발생 시킴
		if(new Random().nextBoolean()) {
			throw new Exception("엄마 호출!!");
		}
		return "정상종료:Boy";
	}
}
