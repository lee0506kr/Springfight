package di01;
public class Car {
	Tire tire;
	
	public void setTire(Tire tire) {
		this.tire = tire; //의존성 주입
	}
	
	public void drive() {
		//실제로 수정된것은 타이어인데, Car역시도 수정해야 한다.
		//>> Car가 KoreaTire 객체의 제어권을 가지고 있기 때문이다.
		//>> 해결하기 위한 방법 : 제어역전 사용하는 객체를 직접 만들지 않고,상위객체에서 만들어서 전달
//		KoreaTire tire = new KoreaTire("굴러갑니다.");
		
		tire.roll();
	}
}
