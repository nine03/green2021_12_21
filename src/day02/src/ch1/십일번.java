package ch1;

import java.util.Scanner;

class Add {
   private int a;
   private int b;
   public void setValue(int a, int b) {
      this.a = a;
      this.b = b;
   }
   public int calculate() {
      return a+b;
   }
}
class Sub {
   private int a;
   private int b;
   public void setValue(int a, int b) {
      this.a = a;
      this.b = b;
   }
   public int calculate() {
      return a-b;
   }
}
class Mul {
   private int a;
   private int b;
   public void setValue(int a, int b) {
      this.a = a;
      this.b = b;
   }
   public int calculate() {
      return a*b;
   }
}
class Div {
   private int a;
   private int b;
   public void setValue(int a, int b) {
      this.a = a;
      this.b = b;
   }
   public int calculate() {
      return a/b;
   }
}

public class ���Ϲ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
	      int result=0;
	      System.out.print("�� ������ �����ڸ� �Է��Ͻÿ� >> ");
	      int a = sc.nextInt();
	      int b = sc.nextInt();
	      char c = sc.next().charAt(0);
	      switch(c) {
	      case '+' : 
	         Add add = new Add();
	         add.setValue(a, b);
	         result = add.calculate();
	         break;
	      case '-' :
	         Sub sub = new Sub();
	         sub.setValue(a, b);
	         result = sub.calculate();
	         break;
	      case '*' :
	         Mul mul = new Mul();
	         mul.setValue(a, b);
	         result = mul.calculate();
	         break;
	      case '/' :
	         Div div = new Div();
	         div.setValue(a, b);
	         result = div.calculate();
	         break;
	      }
	      System.out.println(result);
	      sc.close();
	}

}
