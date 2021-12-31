package day13;

import java.util.ArrayList;
import java.util.Objects;

class Point {
	   int x, y;

	   public Point(int i, int j) {
	      x = i;
	      y = j;
	   }

	   @Override
	   public int hashCode() {
	      final int prime = 31;
	      int result = 1;
	      result = prime * result + x;
	      result = prime * result + y;
	      return result;
	   }

	   @Override
	   public boolean equals(Object obj) {
	      if (this == obj)
	         return true;
	      if (obj == null)
	         return false;
	      if (getClass() != obj.getClass())
	         return false;
	      Point other = (Point) obj;
	      if (x != other.x)
	         return false;
	      if (y != other.y)
	         return false;
	      return true;
	   }

	
	
	
	public String toString() {
		
		return String.format("(%d,%d)",x,y);
	}
}


public class Ch06Ex03 {

	
	public static void main(String[] args) {
		ArrayList<Point> pList = new ArrayList<Point>(); // 배열같은 구조 index(순서)
		pList.add(new Point(2,3));
		pList.add(new Point(4,5));
		pList.add(new Point(6,7));
		pList.add(new Point(8,9));
		pList.add(new Point(1,2));
		
		//System.out.println(pList);
//		System.out.println(pList.get(1));
//		pList.set(1, new Point(100,200));
//		System.out.println(pList.get(1));
//		System.out.println(pList);
//		System.out.println("size =>" + pList.size());
		
		// 컬렉션의 결과를 배열로 쉽게 변경할수 있다.
//		Point[] arr = new Point[pList.size()];
//		pList.toArray(arr); // 배열로 바꿔줄수있다.
//		System.out.println(Arrays.toString(arr));
		
		
		// indexOf // 같은 요소가 있다면 index 반환, 아니면 -1반환
		// ArrayList에서 객체의 위치를 찾기위해서는 equals()를 재정의 해야한다.
		// 다른 컬렉션에서도 검색이 가능하려면 hashcode도 재정의 해야한다.
		System.out.println(pList.indexOf(new Point(8,9)));
		System.out.println(pList.contains(new Point(40,5)));
	}
	
	public static void test(String[] args) {
		Point a = new Point(2,3);
		Point b = new Point(2,3);
		Point c = new Point(3,4);
		
		System.out.println(a == b); // false  <- 인스턴스의 참조값 비교
		System.out.println(a.equals(b)); // 객체는 equals 비교한다  true
		System.out.println(a.equals(c)); // false
	}

}
