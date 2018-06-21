package robot;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

public class Transformer extends Robot {
	
	public Transformer() {
		this.name = "트랜스포머";
//		this.attack = attack;
//		this.move = move;
	}
	
	
//	public void setProperties(Attackable attack,Moveable move) {
//		this.attack = attack;
//		this.move = move;
//	}
	public void setProperties(Map<String, Object> prop) {
		Attackable attack = (Attackable)prop.get("gunAttack");
		Moveable move = (Moveable)prop.get("flyMove");
		this.attack = attack;
		this.move = move;
	}
	
//	public void attack() {
//		//System.out.println("총으로 공격!!"); //5만줄
//		attack.attack();
//	}
//	
//	public void move() {
////		System.out.println("뛰어서 이동!!"); //10만줄
//		move.move();
//	}
	
	
}
