package day14;

import java.util.Arrays;
import java.util.Scanner;

public class test4 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		// 날짜 연습용이 아닌 배열 연습용 예제
		int[] days;
		// 배열 선언 후에 배열을 대입하기 - new 연산자를 사용해야한다.
		days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		//System.out.println(days.length);
		System.out.printf("1년은 %d개월입니다.\n",days.length);
		
		System.out.println("월 입력>>> ");
		int month = sc.nextInt();
		
		int total = 0; 
		// 입력된 월의 날짜가 몇일까지인지 출력하라.
		// 1년은 365일입니다. (days의 모든 날짜를 total에 누적해서 출력한다.)
		// days[1]  ==== 2월의 날짜수 
		// days[month-1] ==== 입력받은 월의 날짜
		System.out.printf("%d월은 %d일까지 있다.\n",month,days[month-1]);
		
		for(int i=0; i<days.length; i++) {
			total = total + days[i];
		}
		System.out.printf("1년은 %d일입니다.\n",total);
		
		// 날짜입력
		System.out.println("일 입력>>> ");
		int day = sc.nextInt();
		
		total = day;
		for(int i=0;i<month-1;i++) {
			total += days[i];  //누적이된다
		}
		
		System.out.printf("1월 1일 부터 %d월 %d일까지는 %d일이 지났다.\n",month,day,total);
		// 과제 : 날짜입력 유효성 체크 구현.
		//  1월1일부터 입력받은 월/일까지 몇일이 지났습니다.
		while(days[month-1]<0||days[month-1]<day) {
			System.out.printf("잘못 입력했습니다. %d월의 날자는 %d 일까지 입니다.\n",month,days[month-1]);
			System.out.println("일 입력>>> ");
			day = sc.nextInt();
		}
		total = day;
		for(int i = 0;i < month-1; i++) {
			total += days[i];
		}
		System.out.printf("1월1일부터 %d월 %d일 까지는 %d 일이 지났습니다.\n",month,day,total);
		
		// 과제2 : 0월0일부터 1년의 남은 날짜는 00일입니다.
		// (365 - total 빼기 금지)
		
		total = 0;
		for(int i = month; i < 12; i++) {
			total += days[i];
		}
		total += days[month-1]-day;
		System.out.printf("%d월 %d일 부터 12월 31일까지는 %d 일이 남았습니다.\n",month,day,total);
		
		total = 0;
		
		// 과제3 : 입력 월/일의 100일 후의 날짜 출력.
				int month1 = month;
				for(total=days[month1-1]-day;total<=100;total+=days[month1++]) {
					
					if(month1 == 12) { //12월이 지나면 1월로
						month1 = 0;
					}
				}
				System.out.printf("%d월 %d일의 100일 후는 %d월 %d일 입니다\n",month,day,month1,days[month1-1]-(total-100));
				
				// 과제4 : 확장 해보기 - 100일 후의 날짜를 200일 300일 특정 날수 적용되게하세요.
				System.out.printf("%d월 %d일에서 며칠 후의 날짜를 표시 할까요? >> ",month,day);
				int num = sc.nextInt();
				month1 = month;
				for(total =days[month1-1]-day;total<=num;total+=days[month1++]) {
					if(month1 == 12) {
						month1 = 0;
					}
				}
				System.out.printf("%d월 %d일의 %d일 후는 %d월 %d일 입니다\n",month,day,num,month1,days[month1-1]-(total-num));

	}

}
