package day14;

import java.util.Scanner;

public class test5 {

	static int[] days = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
	static Scanner sc = new Scanner(System.in);
	static int month = 0;
	static int day = 0;
	static int total = 0;
	static int rd = 0;
	 int day100 = 0;
	 
	 public static int getMonth() {
		 while(true) {
			 try {
				 System.out.print("원하는 달을 입력하세요 >>");
				 month = sc.nextInt();
				 break;
			 } catch (Exception e) {
				 System.out.println("입력에 실패했습니다.");
				 System.out.println("숫자만 입력해주세요.");
				 sc.next();
				 continue;
			 }
		 }
		 return month;
	 }
	 
	 public static int getDay() {
		 while(true) {
			 try {
				 System.out.print("원하는 날짜를 입력하세요 >>");
				 day = sc.nextInt();
				 break;
			 } catch(Exception e) {
				 System.out.println("입력에 실패했습니다");
				 System.out.println("숫자만 입력해주세요.");
			 }
		 }
		 return day;
	 }
	public static void main(String[] args) {
		
		getMonth();
		while(month > 12 || month <= 0) {
			try {
				System.out.println("입력에 실패했습니다.");
				System.out.println("1~12월 사이 중에 입력하세요");
				System.out.print("숫자 입력 >>");
				month = sc.nextInt();
				continue;
			}catch (Exception e) {
				System.out.println("입력에 실패했습니다.");
				System.out.println("숫자만 입력해주세요.");
				sc.next();
				continue;
			}
		}
		
		getDay();
		while(day > days[month -1] || day <= 0) {
			try {
				System.out.println("입력에 실패했습니다.");
				System.out.printf("1~%d일 사이 중에 입력하세요.\n",days[month - 1]);
				System.out.print("숫자 입력 >>");
				day = sc.nextInt();
				continue;
			} catch(Exception e) {
				System.out.println("입력에 실패했습니다.");
				System.out.println("숫자만 입력해주세요.");
				sc.next();
				continue;
			}
		}
		
		for(int i = 0; i < days.length; i++) {
			total += days[i];
		}
		System.out.printf("1년은 %d일입니다.\n",total);
		System.out.printf("입력하신 %d 월은 %d일까지 입니다.\n",month,days[month - 1]);
		System.out.println();
		
		total = 0;
		for(int i = 0; i < month - 1; i++) {
			total += days[i];
			rd = total + day;
		}
		System.out.printf("1월 1일부터 %d월 %d일 까지는 %d일이 지났습니다. \n",month,day,rd + 1);
		System.out.println();
		
		total = 0;
		rd = 0;
		
		for(int i = month - 1; i < days.length; i++) {
			total += days[i];
			rd = total - day;
		}
		
		System.out.printf("%d월 %d일부터 1년은 남의 날짜는 %d 일입니다.\n",month,day,rd);
		System.out.println();
		
		int countDay;
		int count = 0;
		int dMonth = month;
		int dDay = 1;
		System.out.println("특정 날짜를 알아보려고 해요.");
		System.out.print("몇일 후의 날짜를 알아볼까요? >>");
		countDay = sc.nextInt();
		System.out.printf("%d일 후의 날짜를 계산합니다.\n",countDay);
		total = 0;
		
		int tempDay = day;
		for(int i = 0; i < countDay; i++) {
			tempDay++;
			if(dMonth == 2 && tempDay > days[1]) {
				tempDay = 1;
				dMonth++;
				if(dMonth > days.length) {
					dMonth = 1;
				}
			}else if(dMonth == 1 && tempDay > days[0])
				tempDay = 1;
				dMonth++;
				if(dMonth > days.length) {
					dMonth = 1;
				}else if(dMonth == 3 && tempDay > days[2]) {
					tempDay = 1;
					dMonth++;
					if(dMonth > days.length) {
						dMonth = 1;
					}
				}else if(dMonth == 4 && tempDay > days[3]) {
					tempDay = 1;
					dMonth++;
					if(dMonth > days.length) {
						dMonth = 1;
					}
				}
		}
	}

}
