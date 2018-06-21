package robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Gundam extends Robot {

	@Autowired
	public Gundam(@Qualifier("gunAttack") Attackable attack, @Qualifier("runMove") Moveable move) {
		this.name = "건담";
		this.attack = attack;
		this.move = move;
	}

	// @Override
	// public void attack() {
	// //System.out.println("총으로 공격!!"); //5만줄
	// attack.attack();
	// }
	//
	// @Override
	// public void move() {
	//// System.out.println("날아서 이동!!"); //10만줄
	// move.move();
	// }

}
