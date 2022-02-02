package org.comstudy21;

public class HelloWorld {
	String name;
	String message;
	
	public HelloWorld(String name, String message) {
		this.name = name;
		this.message = message;
		System.out.println("HelloWorld 클래스의 생성자!");
	}
	
	public void sayHello() {
		System.out.printf("%s님 %s",name,message);
	}
}
