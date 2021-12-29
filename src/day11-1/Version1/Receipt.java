package homework;

import java.util.Scanner;

public class Receipt {
	public static final double TAX_RATE = 1.1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("원하시는 음료가 몇잔인가요? : ");
		
		Menu[] menus = new Menu[sc.nextInt()];
		
		for(int i =0; i < menus.length; i++) {
			System.out.println((i+1) + "번째 음료의 품명, 단가, 수량을 입력해주세요");
			menus[i] = new Menu(sc.next(),sc.nextInt(),sc.nextInt());
		}
		System.out.println();
		
		int totalPrice = 0;
		
		System.out.println("---------------------------------");
		System.out.println("품명\t단가\t수량\t금액");
		System.out.println("---------------------------------");
		
		for(int i = 0; i < menus.length; i++) {
			System.out.printf("%s\t%,6d\t%3d\t%,6d원\n",
					menus[i].name, menus[i].Price,
					menus[i].count,(menus[i].Price * menus[i].count));
			totalPrice += (menus[i].Price * menus[i].count);
		}
		int supplyPrice = (int )(totalPrice / TAX_RATE);
		int vat = totalPrice - supplyPrice;
		
		System.out.println("---------------------------------");
		System.out.printf("공급가액\t\t\t%,6d원\n", supplyPrice);
		System.out.printf("부가세액\t\t\t%,6d원\n", vat);
		System.out.println("---------------------------------");
		System.out.printf("청구금액\t\t\t%,6d원\n", totalPrice);
		
		sc.close();
	}
}
