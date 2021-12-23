package org.comstudy23.ch05_3;

class People {
	// 이름, 나이, 직업이 저장되는 필드
	private String name;
	private int age;
	private String job;
	
	// 개발자가 매개변수 있는 생성자를 직접 구현하면 
	// 매개변수 없는 디폴트 생성자도 반드시 구현 해줘야 한다/
	public People() {
		this("",0,"");
	}
	
	// People의 생성자 (생성자 오버로딩) 인자있는 생성자 인자가 없는것은 디폴트 생성자
	// 매개변수는 지역변수이다.
	public People(String name, int age, String job) {   
		this.name = name;
		this.age = age;
		this.job = job;
	}

	public void showInfo() {
		System.out.printf("People [성명=%s, 나이=%d, 직업=%s]\n",name,age,job);
		
	}

	public void setInfo(String name, int age, String job) {
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
}

public class Ch05Ex05 {

	public static void main(String[] args) {
		People people1 = new People("홍길동",23,"의적"); // 파라미터 아큐먼트 인자
		 people1.showInfo(); // 필드의 값을 출력.
		 
		 People people2 = new People();
		 people2.setInfo("이순신",35,"장군");
		 people2.showInfo();
	}

}
