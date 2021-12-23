package org.comstudy23.ch05;

// 1개의 java 파일에 여러 클래스 선언 가능(패키지 멤버)
// 한 점을 구성하는 x,y좌표를 저장하는 객체의 클래스
class Point {   // 앞에 public을 선언할수없다
	private int x,y;
	
	public void set(int x, int y) {
		this.x = x; 
		this.y = y;
	}

	public void showPoint() {
		System.out.printf("(%d, %d)\n",x,y);
		
	}
}
// Point를 확장한 ColorPoint 클래스 선언 
// class 서브클래스명 extends 슈퍼클래스명 {}
// 서브클래스의 내용에 슈퍼클래스의 내용이 포함된다는 의미.

class ColorPoint extends Point { //Point 내용일 들어감 
	private String color;
	public void setColor(String color) {
		this.color = color;
	}
	public void showColorPoint() {
		System.out.print(color);
		showPoint();
		
	}
}

class Point3D extends Point {
	private int z;

	public void set(int x, int y, int z) {
		// x, y는 부모 클래스로 넘기기
		set(x,y);  // ctrl + 마우스 눌러보기 
		this.z = z;
	}

	public void show3DPoint() {
		// 부모의 메소드 호출
		showPoint();
		System.out.println(z);
	}
}

public class Ch05Ex01 {
	
	public static void main(String[] args) {
		// Point를 화작한 Point3D 클래스를 선언화고 사용하기
		Point3D p3d = new Point3D();
		p3d.set(10,20,15); // x,y,z
		p3d.show3DPoint();
	}
	
	public static void main01(String[] args) {
		ColorPoint cp = new ColorPoint();
		cp.set(3,4);
		cp.setColor("red");
		cp.showColorPoint();
	}
	
	
	public static void main00(String[] args) {
		Point p = new Point();
		p.set(1,2);
		p.showPoint();

	}

}
