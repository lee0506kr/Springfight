package robot;




public class Robot {
	
	String name;
	Attackable attack;
	Moveable move;
	
	
	public void fight() {
		System.out.println(name + "전투시작");
		attack();
		move();
		attack();
		System.out.println(name + "전투를 종료합니다.");
	}

	public  void attack() {
		attack.attack();
	};

	public  void move() {
		move.move();
	};
	
}
