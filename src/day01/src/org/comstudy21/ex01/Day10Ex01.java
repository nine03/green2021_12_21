package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;


public class Day10Ex01 {
	static Scanner scan = new Scanner(System.in);
	//인스턴스 멤버기 때문에 접근못한다 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money = 0;
		int price = 240;
		int [] arr = {5000,1000,500,100,50,10};
		
		//int a;
		out.printf("물건 값이 %d원입니다. \n", 240);
		out.print("현금입력 : ");
		money = scan.nextInt();
		// 다음과 같이 출력되도록 구현 하세요.(반복문 사용 가능)
		// 10000만원을 입력 받았다면 
		// 5000원권 1개
		// 1000원권 4개
		// 500원권 1개
		// 100원권 2개
		// 50원권 1개
		// 10원권 1개
		//a = money - price;
		//if(a >= 0) {
			//out.print("잔액 : " + a + "원");
		//}else {
			//out.print("잔액 부족 \n 남아있는 잔액은 :" + a + "원입니다.");
		//}
		
		//int t = money / 2;
		//int t1 = t / 5;
		//int t2 = t1 / 2;
		//int t3 = t2 / 5;
		//int t4 = t3 / 2;
		//int t5 = t4 / 5;
		//int t6 = t5 / 10;
 		
		//out.print("\n");
		//out.print("잔액 : " + t + "원" );
		//out.print("\n");
		//out.print("잔액 : " + t1 + "원");
		//out.print("\n");
		//out.print("잔액 : " + t2 + "원");
		//out.print("\n");
		//out.print("잔액 : " + t3 + "원");
		//out.print("\n");
		//out.print("잔액 : " + t4 + "원");
		//out.print("\n");
		//out.print("잔액 : " + t5 + "원");
		//out.print("\n");
		//out.print("잔액 : " + t6 + "원");
		//out.print("\n");
		
		int m = (money - price);
		for(int i = 0; i < arr.length; i++) {
			int num = m / arr[i];
				m = m % arr[i];
				out.print(arr[i] + "원권 ");
				arr[i] = num;
				out.print(arr[i] + "개 ");
				out.print("\n");
		}

	}

}
