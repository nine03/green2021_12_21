package day12;

import static java.lang.System.out;

public class Day12Ex03 {

	public static void main00(String[] args) {
		// 1+2+3+4+5+6+7+8+9+10 = 55
		// while문으로 구현하기 
		final int MAX = 10;
		
		// 누적하는 변수는 0으로 초기화
		int sum = 0; // 1부터 10까지 누적
		int num = 1; // 1부터 10까지 하나씩 증가 용도

		while(num <= 10) {
			sum += num;
			System.out.print(num);
			System.out.print(num != MAX ? "+" : "=");  //삼함연산자 만약에 ?  아니면 + 맞으면 =
			num++;
			
		}
		System.out.println(sum);
	}
	// 생존을 위해 사는것은 표류이고 
	// 즐기면서 사는것은 여행이다.
	public static void main01(String[] args) {
		// 1+2-3+4-5+6-7+8-9+10=7
		final int MAX = 10; //상수로 만들었기때문에 사용
		// 누적하는 변수는 0으로 초기화
		final int MIN = 1;
		int sum = 0; // 1부터 10까지 누적
		int num = MIN; // 1부터 10까지 하나씩 증가 용도
		
		//숫자 연산 
		// 1. 1~10까지 출력 (num을 증가하면서 출력한다.)
		// 2. 연산
		// if문 사용
		// 수열 반복문 
		// 예외를 주면된다  더하기 
		
 		while(num <= MAX) {
 			out.print(num);
 			if(num % 2 == 1) {  //짝수  0이 아닐떄 혹수  나머지가 1이면 홀수 
 				//sum = num == 1 ? sum + num : sum - num;
 				//sum = num == 1 ? num : sum - num;
 				sum = num == MIN  ? num : sum - num;
 				out.print("+"); // 감소
 			}else {
 				sum += num;
 				out.print(num == MAX ? "=" : "-"); // 누적 
 			}
 			num = num + 1;
		}
 		out.println(sum);
	}
	
	public static void main02(String[] args) {
		final int MAX = 21;
		// 피보나치 수열 누적
		// 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 = 54
		// 앞에 두개항을 더해서 그다음항에 
		// 변수는 3개 이상 필요하다 
		
		int prev = 0;  // 이전항
		int curr = 1;  // 현재항 
		int next = 0; // 다음항 
		int sum = 0;//누적 
		
		while(curr <= MAX) { //같은때 오류남 결과가 참이여야지 반복한다 작다 미만 작거나 같다 
			//누적하기 
			sum += curr;
			System.out.print(curr);
			System.out.print(curr == MAX ? "=" : "+" );  // 예외 처리를 하지않으면 무한대로 돈다.
			
			//치환해서 증가하기 
			// 1. 다음항은 이전항 + 현재항  next = perv + curr;
				next = prev + curr;
			// 2. 현재항은 이전항으로 치환    prev = curr
				prev = curr; // 치환 값을 바꾸다
			// 3. 다음항은 현재항으로 치환(새로운 현재항)
				curr = next;
		}
		out.println(sum);
	}
	public static void main03(String[] args) {
		final int MAX = 21;
		// 피보나치 수열 누적
		// 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 = 54
		// 앞에 두개항을 더해서 그다음항에 
		// 변수는 3개 이상 필요하다 
		
		//int prev = 0;  // 이전항
		//int curr = 1;  // 현재항 
		//int next = 0; // 다음항 
		int sum = 0;//누적 
		
		//for문으로 포스팅해보기
		for(int p = 0,curr = 1,n = 0 ;curr <= MAX;n=p+curr,p=curr,curr=n) {
		 // while(curr <= MAX) { //같은때 오류남 결과가 참이여야지 반복한다 작다 미만 작거나 같다 
			//누적하기 
			sum += curr;
			System.out.print(curr);
			System.out.print(curr == MAX ? "=" : "+" );  // 예외 처리를 하지않으면 무한대로 돈다.
		}
			//치환해서 증가하기 
			// 1. 다음항은 이전항 + 현재항  next = perv + curr;
			//	next = prev + curr;
			// 2. 현재항은 이전항으로 치환    prev = curr
			//	prev = curr; // 치환 값을 바꾸다
			// 3. 다음항은 현재항으로 치환(새로운 현재항)
				//curr = next;
		out.println(sum);
		}
	public static void main04(String[] args) {
		final int MAX = 21;
		// 피보나치 수열 누적
		// 1 + 1 - 2 + 3 - 5 + 8 - 13 + 21 = 14
		int prev = 0; // 이전항
		int curr = 1; // 현재항
		int next = 0; // 다음항
		int sum = 0; //누적 
		
		for(int i = 1; curr <= MAX; i++) {
			out.print(curr);
			if(i % 2 == 1) {
				sum = curr == 1  ?  curr : sum - curr;
					out.print("+"); //감소 
			} else {
				sum += curr;
					out.print(curr == MAX ? "=" : "+" ); // 누적
			}
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		out.println(sum);
	}
	public static void main05(String[] args) {
		final int MAX = 21;
		// 피보나치 수열 누적
		// 1 + 1 - 2 + 3 - 5 + 8 - 13 + 21 = 14
		int prev = 0; // 이전항
		int curr = 1; // 현재항
		int next = 0; // 다음항
		int sum = 0; //누적 
		
		int i = 1;
		while(curr <= MAX) { //참이면 
			System.out.print(curr);
			//System.out.printf("(%s)",i % 2 ==1 "+" : "-");  //괄호에있는부분이 부호  홀수는 + 짝수는 -
			// i % 2 != 0 
			// i % 2 ==1 "+" : "-"
			
			if(i % 2 ==1) {
				sum = i == 1 ? curr : sum - curr;
				System.out.print("+");
			}else {
				sum += curr;
				System.out.print(curr == MAX ?  "=": "-"); 
			}
				
			//치환시켜주기 
			next = prev + curr;
			prev = curr;
			curr = next;
 			
			i = i + 1;
			
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		final int MAX = 21;
		// 피보나치 수열 누적
		// 1 + 1 - 2 + 3 - 5 + 8 - 13 + 21 = 14
		int prev = 0; // 이전항
		int curr = 1; // 현재항
		int next = 0; // 다음항
		int sum = 0; //누적 
		
		// 생각사
		// 배우고 생각하지 않으면 망한다.
		// 배우고 생각하지 않으면 워태롭다 - 공자
		
		// 질문하라. 질문이 곧 공부다.
		// 외우기만 한 공부가 나라를 망하게 한다. - 정약전(자산어보)
		
		//한번는 플러스 한번은 마이너스  
		//flag알고리즘
		//true 더하고 false 빼기 
		boolean flag = true;
		while(curr <= 21) {
			System.out.print(curr);
			
			if(flag) {
				sum = curr == 1 ? curr : sum - curr;
				System.out.print("+"); // 이쪽한번 찍어주고 변경 
				flag = false;
			}else {
				//System.out.print("-"); // 이쪽한번 찍어주고 변경
				sum += curr;
				System.out.print(curr == MAX ?  "=": "-"); 
				flag = true;
			}
			
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		System.out.println(sum);
	}
}

