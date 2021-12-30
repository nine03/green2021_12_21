package ch05.ex05;

public class Point3D extends Point {
	private int z;
	
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	private void moveDown() {
		z--;
		
	}

	private void moveUp() {
		z++;
	}
	
	// 부모의 move() 메소드 오버로딩
	private void move(int x, int y, int z) {
		super.move(x, y);
		this.z = z;
	}
	
	@Override
	public String toString() {
		
		return String.format("(%d, %d, %d)의 점",getX(),getY(),z);
	}
	
	public static void main(String[] args) {
		Point3D p = new Point3D(1,2,3);
		System.out.println(p + "입니다.");
		
		p.moveUp();
		System.out.println(p + "입니다.");
		p.moveDown();
		System.out.println(p + "입니다.");
		
		p.move(10, 10);
		System.out.println(p + "입니다.");
		p.move(100, 300, 300);
		System.out.println(p + "입니다.");
	}
}
