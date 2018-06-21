package robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GunAttack implements Attackable{
	
//	public GunAttack(int a) {
//		System.out.println(a);
//	}

	public void attack() {
		System.out.println("총으로 공격!!");
	}
}
