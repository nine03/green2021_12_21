package ch05.ex12_2;

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

class ShapeLinkedList {
	private Shape start,last,node,cur;
	private int size = 0;
	
	public void append(Shape shape) { // 연결 리스트로 연결  append가 됐다 
		size++;
		if(start == null) {
			start = shape;
			last = start; //첫번째 노드 생성
			// System.out.println(">>> 첫번째 노드 생성");
			return;
		}
		node = shape;
		last.next = node;
		last = node;
		// System.out.println(">>> 마지막 노드 추가");
	}

	public void showAll() {
		cur = start; 
		while(cur != null) { 
			cur.draw(); // 만약 검색하면 여기다가 if문 넣어주면된다.
			cur = cur.next; // 그다음 노드 
		}
		
	}

	public void remove(int i) {
		//size--;
		// TODO Auto-generated method stub
		
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
}
// 모듈로 배열을 만들기 
public class ShapeEx {
	// ShapeLinkedList
	public static void main(String[] args) {
		ShapeLinkedList linkedList = new ShapeLinkedList(); // ShapeLinkedList 배열 대신에서 들어가는것 
		linkedList.append(new Circle()); // linkedList 연결 
		linkedList.append(new Rect());
		linkedList.append(new Line());
		linkedList.append(new Circle());
		
		linkedList.showAll();
		linkedList.remove(3);
		System.out.println(linkedList.size()); // 노드가 몇개 있는지 확인 
	}

}
