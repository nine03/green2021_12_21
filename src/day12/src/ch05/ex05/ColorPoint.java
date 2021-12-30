package ch05.ex05;

public class ColorPoint extends Point {
	
	private String color;
	
	//생성자 오버로딩
	public ColorPoint(int x, int y, String color) {
		super(x, y); // super 먼저 호출
		this.color = color;
	}
	
	// default 생성자
	public ColorPoint() {
//		super(0,0);
//		this.color = "BLACK";
		// 다른 생성자 호출 
		this(0,0,"BLACK");
	}

	private void setColor(String color) {
		this.color = color;
	}

	private void setXY(int x, int y) {
		super.move(x, y);
	}
	
	@Override
	public String toString() {
		// 객체를 사용하면 자동으로 호출된다.
		return String.format("%s색의 (%d,%d)의 점", color,getX(),getY());
	}
	
	public static void main(String[] args) {
		ColorPoint zeroPoint = new ColorPoint(); // (0,0) 위치의 BLACK
		System.out.println(zeroPoint + "입니다.");
		
		test01(null); // test01 호출 
	}
	
	public static void test01(String[] args) {
		ColorPoint cp = new ColorPoint(5,5,"YELLOW");
		cp.setXY(10,20);
		cp.setColor("RED");
		//String str = cp.toString();
		System.out.println(cp + "입니다.");
	}

}
