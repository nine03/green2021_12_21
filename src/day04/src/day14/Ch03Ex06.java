package day14;

import java.util.Arrays;
import java.util.Scanner;

public class Ch03Ex06 {

	public static void main_note(String[] args) {
		// 1차배열 
		// 배열이란?
		
		// 자바의 배열선언 중괄호{ } 사용.
		// 배열은 타입이 배열 타입.
		// 배열 오브젝트이다.
		
		
		// 스트링 배열 타입 - 특정타입에 브라켓츠를 붙이면 배열 타입된다.
		String[] a;
		// 인트 배열 타입
		int[] b;  
		// char 2바이트이지만 모든 배열의 참조변수는 정수를 저장하는 4바이트이다.
		// 참조값은 모두 정수이다.
		// 배열도 오브젝트이므로 변수는 참조변수가 된다.
		char[] c;

	}
	public static void main00(String[] args) {
		// 배열 선언과 동시에 초기화 하기
		// 배열 리터럴
		int[] arr = {10, 20, 30, 40};
		
		arr[1] = 5000; //참조할수있고 수정할수도있다
		
		//배열 출력
		System.out.println(Arrays.toString(arr));
		
		// 반복문을 이용해서 배열 출력
		// 배열의 첫번째 요소의 첨자는 0이고 
		//배열의 마지막 요소의 첨자는 배열크기 -1이다.
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("arr[arr.length-1] ===> " + arr[arr.length-1]);
	}
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// 함수의 인자로 배열을 생성과 동시에 전달 할때 사용.
		//main00(new String[]{"aa","bb","ccc"}); 
		
		// 날짜 연습용이 아닌 배열 연습용 예제
		int[] days;
		// 배열 선언 후에 배열을 대입하기 - new 연산자를 사용해야한다.
		days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		//System.out.println(days.length);
		System.out.printf("1년은 %d개월입니다.\n",days.length);
		
		System.out.println("월 입력>>> ");
		int month = scan.nextInt();
		
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
		int day = scan.nextInt();
		
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
			day = scan.nextInt();
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
		int monthBox = month;
		for(total=days[monthBox-1]-day;total<=100;total+=days[monthBox++]) {
			
			if(monthBox == 12) { //12월이 지나면 1월로
				monthBox = 0;
			}
		}
		System.out.printf("%d월 %d일의 100일 후는 %d월 %d일 입니다\n",month,day,monthBox,days[monthBox-1]-(total-100));
		
		// 과제4 : 확장 해보기 - 100일 후의 날짜를 200일 300일 특정 날수 적용되게하세요.
		System.out.printf("%d월 %d일에서 며칠 후의 날짜를 표시 할까요? >> ",month,day);
		int num = scan.nextInt();
		monthBox = month;
		for(total =days[monthBox-1]-day;total<=num;total+=days[monthBox++]) {
			if(monthBox == 12) {
				monthBox = 0;
			}
		}
		System.out.printf("%d월 %d일의 %d일 후는 %d월 %d일 입니다\n",month,day,num,monthBox,days[monthBox-1]-(total-num));
	}
}
