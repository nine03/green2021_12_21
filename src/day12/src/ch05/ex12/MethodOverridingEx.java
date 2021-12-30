package ch05.ex12;

import java.util.Scanner;

class Shape {
	public Shape next;
	public Shape() {
		next = null;
	}
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
}

// CRUD 
// Linked List 연결리스트  map stack 객체안에 추가하고 제거하고 검색하고 
// 배열 대신에 연결리스트에 들어가야한다. 캡슐화 어벤드 리므브 인덱스 배열객체대신해서 선언
// 자료구조는 자료구조대로 mvc는 mvc 대로  묶어서 만들기 
public class MethodOverridingEx {
	public static void main(String[] args) {
		Shape start,last,node;
		
		start = new Line();
		last = start;
		node = new Rect();
		last.next = node;
		last = node;
		node = new Line();
		last.next = node;
		last = node;
		node = new Circle();
		last.next = node;
		last = node;
		Shape cur = start;  // cur  커런트 움직여서 node 순회 연결리스트 
		while(cur != null) {
			cur.draw();
			cur = cur.next;
		}
	}
	
	static void paint(Shape p) {
		p.draw(); // 동적 바인딩
	}

	public static void paint_test(String[] args) {
		Line line = new Line();
		paint(line);
		paint(new Shape());
		paint(new Line());
		paint(new Rect());
		paint(new Circle());
	}

}
