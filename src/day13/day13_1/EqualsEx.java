package day13_1;

// 예제 6 - 3 
public class EqualsEx {
	public static void main(String[] args) {
		Point a = new Point(2,3);
		Point b = new Point(2,3);
		Point c = new Point(3,4);
	
		if(a == b) // false
			System.out.println("a==b");
		if(a.equals(b)) // true
			System.out.println("a is equal to b");
		if(a.equals(c)) // false
			System.out.println("a is equal to c");
	}
}