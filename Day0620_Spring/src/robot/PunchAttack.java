package robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PunchAttack implements Attackable{
	

	public void attack() {
		System.out.println("주먹으로 공격!!");
	}
}
