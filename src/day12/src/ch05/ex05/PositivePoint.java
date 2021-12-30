package ch05.ex05;

public class PositivePoint extends Point {
	
	public PositivePoint() {
		this(0,0);
	}
	
	// 생성자 위에 아무것도 올수가 없다 
	public PositivePoint(int x, int y) {
		super(x,y);
		if(x<0 || y>0) {
			super.move(0, 0);
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("(%d,%d)의 점", getX(),getY());
	}
	
	@Override
	protected void move(int x, int y) {
		if(x>=0 && y>=0) {
			super.move(x, y);
		}
	}
	
	public static void main(String[] args) {
		PositivePoint p = new PositivePoint();
		p.move(10, 10);
		System.out.println(p.toString() + "입니다.");
		
		p.move(-5, 5);
		System.out.println(p.toString() + "입니다.");
		
		PositivePoint p2 = new PositivePoint(-10,-10);
		System.out.println(p2.toString() + "입니다.");
	}

}
