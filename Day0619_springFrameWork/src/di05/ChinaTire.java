package di05;

import org.springframework.stereotype.Component;

//@Component("chinaTire")
public class ChinaTire implements Tire {

	public void roll() {
		System.out.println("중국 타이어 잘굴러 갑니다..");
	}
}
