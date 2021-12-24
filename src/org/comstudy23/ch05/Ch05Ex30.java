package org.comstudy23.ch05;

class 할베 {
	public void 나팔() {
		System.out.println("할베의 나팔 뽕!");
	}
}

class 아베 extends 할베 {
		@Override
		public void 나팔() {
		System.out.println("아베의 나팔 뽕!");
	}
}

class 손자 extends 아베 {
	@Override
	public void 나팔() {
		System.out.println("손의 나팔 뿡!");
	}
}

public class Ch05Ex30 {

	public static void main(String[] args) {
		할베[] family = new 할베[5];  // 참조변수 5개가 생긴다
		family[0] = new 할베();
		family[1] = new 아베();
		family[2] = new 손자();
		family[3] = new 아베();
		family[4] = new 손자();
		
		// 동적 바인딩 
		for(할베 h : family) { // 확장 for문
			h.나팔();
		}
	}
}
