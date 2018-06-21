package robot;

import org.springframework.stereotype.Component;

@Component
public class FlyMove implements Moveable{
	
	public void move() {
		System.out.println("날아서 이동!!");
	}
}
