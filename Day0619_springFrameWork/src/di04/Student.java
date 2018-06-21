package di04;

public class Student {
	private int snum;
	private String sname;
	private int sgrade;
	
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSgrade() {
		return sgrade;
	}
	public void setSgrade(int sgrade) {
		this.sgrade = sgrade;
	}
	@Override
	public String toString() {
		return sname;
	}
}
