package aop2;

import java.util.Random;

public class Boy implements Person{
	public void doSomething() throws Exception {
		System.out.println("피시방을 가서 게임을 한다.");
		//랜덤하게 예외를 발생 시킴
		if(new Random().nextBoolean()) {
			throw new Exception("엄마 호출!!");
		}
		
	}
}
