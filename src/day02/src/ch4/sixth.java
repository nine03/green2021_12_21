package ch4;

import java.util.Scanner;

class Circle {
	   private double x, y;
	   private int radius;
	   public Circle(double x, double y, int radius) {
	      this.x = x; //x, y, radius 초기화
	      this.y =y;
	      this.radius = radius;
	   }
	   public void show() {
	      System.out.println("(" + x + "," + y + ")"+ radius);
	   }
	   public int getRadius() {
	      return radius;
	   }
	}

public class sixth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	      Circle c[] = new Circle[3]; // 3개의 Circle 배열 선언
	      int max=0; 
	      for(int i=0; i < c.length; i ++) {
	         System.out.print("x, y, radius >>");
	         double x = sc.nextDouble(); // x값 읽기.
	         double y = sc.nextDouble(); // y값 읽기.
	         int radius = sc.nextInt(); // radius값 읽기.
	         c[i] = new Circle(x, y, radius); // Circle 객체 생성
	      }
	      for(int i=0; i<c.length; i++) 
	         if(max < c[i].getRadius())
	            max = c[i].getRadius();
	      for(int i=0; i<c.length; i++)
	         if(max == c[i].getRadius()) {
	            System.out.print("가장 면적인 큰 원은 ");
	            c[i].show();
	         }
	      sc.close();
	}

}
