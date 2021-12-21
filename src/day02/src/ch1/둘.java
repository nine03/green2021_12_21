package ch1;

import java.util.Scanner;

class Grade {
	   private int math;
	   private int science;
	   private int english;
	   Grade(int math, int science, int english) {
	      this.math = math;
	      this.science = science;
	      this.english = english;
	   }
	   public int average() {
	      return (math + science + english) / 3;
	   }
	}

public class 둘 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	      
	      System.out.print("수학, 과학, 영어 순으로 3개의 정수 입력 >> ");
	      int math = sc.nextInt();
	      int science = sc.nextInt();
	      int english = sc.nextInt();
	      Grade me = new Grade(math, science, english);
	      System.out.println("평균은 "+me.average());
	      
	      sc.close();
	}

}
