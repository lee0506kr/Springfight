package aop2;

import java.util.Random;

public class Girl implements Person{
	public void doSomething() throws Exception {
		
		System.out.println("쇼핑몰에서 쇼핑을 한다.");
		if(new Random().nextBoolean()) {
			throw new Exception("엄마 호출!!");
		}
		
	}
}
