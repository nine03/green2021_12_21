package org.comstudy23.ch05;

import org.comstudy23.ch05_2.AAA;

// extends Object 생략되어있다 
//class AAA extends Object {
//	private int privateData;
//	int defaultData;
//	protected int protectedData;
//	public int publicData;
//}

class BBB extends AAA {
	public void set() {
		//private 멤버는 서브에서도 접근 불가능.
		//privateData = 10; 
		// 다른 패키지의 디폴트 멤버는 접근 불가능
		//defaultData = 100;
		protectedData = 1000; // 상속되면 접근 가능. 상속 받으면 사용가능 하지만 상속 받지못하면 사용불가능
		publicData = 10000;
	}
}

// extends Object 생략 되어있다 
public class Ch05Ex02 extends Object{

	public static void main(String[] args) {
		AAA aaa = new AAA();
		
		
		//aaa.protectedData = 120;
		aaa.publicData = 2500;
		
		System.out.println(aaa.toString());
		System.out.println(aaa.equals(null));

	}

}
