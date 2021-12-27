package org.comstudy21.saram;

public class SaramMain {
	public static void main(String[] args) {
		System.out.println("----------- 사람 정보 관리 프로그램 -------------");
		R.saramController.action(); // 재귀호출에 의해서 반복 됨.
	}
}