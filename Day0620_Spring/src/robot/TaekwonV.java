package robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TaekwonV extends Robot {
	
	@Autowired
	public TaekwonV(@Qualifier("punchAttack")Attackable attack,@Qualifier("flyMove")Moveable move) {
		this.name = "태권브이";
		this.attack = attack;
		this.move = move;
	}
//	public void attack() {
//		attack.attack();
//	}
//	
//	
//	
//	public void move() {
//		move.move();
//	}
}
