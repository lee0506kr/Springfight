package di01;

public class KoreaTire implements Tire{
	
	String str;
	public KoreaTire(String srt) {
		this.str =srt;
	}
	
	public void roll() {
		//System.out.println("굴러간다.");
		System.out.println("국산타이어 : " + str);
	}
}
