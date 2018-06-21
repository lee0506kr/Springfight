package di01;

public class Driver {
	public static void main(String[] args) {

		Car car = new Car();
		//Tire tire = new KoreaTire("굴러갑니다.");
		Tire tire = new ChinaTire();
		car.setTire(tire);
		car.drive();
		
		//car class 는 koreatire 클래스에 의존한다.
		//car 클래스는 koreatire클래스의 객체를 생성하고 , 없앴다

	}

}
