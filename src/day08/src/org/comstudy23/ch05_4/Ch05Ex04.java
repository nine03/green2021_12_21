package org.comstudy23.ch05_4;

class 사람{
	private String name;
	// 상속받는 클래스를 위해 디폴트 생성자 구현 해 주기.
	public 사람(String name) {
		this.name = name;
		System.out.println(">>> 1. 사람의 생성자 호출!" + name);
	}
}

class 학생 extends 사람 {
	public 학생() {
		// 부모의 디폴트 생성자(매개변수 없는 생성자) 자동으로 호출한다.
		// 만약 부모의 디폴트 생성자가 없다면 명시적으로 매개변수 있는 생성자를 호출 해야한다.
		super("no-name");
		System.out.println(">>> 2. 학생의 생성자 호출!");
	}
}
class 근로학생 extends 학생 {
	public 근로학생() {
		System.out.println(">>> 3. 근로학생의 생성자 호출!");
	}
}
	
public class Ch05Ex04 {
	public static void main(String[] args) {
		근로학생 studentWorker = new 근로학생(); //타입이 근로학생
	}
}
