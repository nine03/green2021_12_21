package ch2;

import static java.lang.System.out;

public class Day12Ex03 {

	public static void main(String[] args) {
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

}
