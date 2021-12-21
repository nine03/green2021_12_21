package org.comstudy21.exam1;

import java.util.Scanner;

public class Day11Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] unit = {50000,10000,1000,500,100,50,10,1};
		int money;
		System.out.print("금액을 입력하시오>>");
		money = sc.nextInt();
		
		for(int i = 0; i < unit.length; i++) {
			System.out.printf("%d 원 짜리: %d개\n",unit[i],money / unit[i]);
			money = money - (money / unit[i]) * unit[i];
		}
		sc.close();
	}

}
