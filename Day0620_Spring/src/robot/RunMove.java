package robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunMove implements Moveable {

	public void move() {
		System.out.println("뛰어서 이동!!");
	}
}
