package org.comstudy21.exam1;

import java.util.Scanner;

public class Day11Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[];
		int n ;
		
		System.out.print("정수 몇개?");
			n = sc.nextInt();
		
		 arr = new int[n];
	      for(int i = 0; i < arr.length; i++) {
	         int tmp = (int)(Math.random() * 100 + 1);
	         int chk = 0;
	         for(int j = 0; j < arr.length; j++) {
	        	 if(tmp == arr[j]) {
	        		 chk = 1;
	        		 break;
	        	 }
	         }
	         if(chk == 1) {
	        	 i--;
	        	 continue;
	         }
	         arr[i] = tmp;
	      }
	      
	      for(int i = 0; i < arr.length; i++) {
	         if(i % 10 == 0 && i != 0) 
	        	 System.out.println();
	         System.out.print(arr[i] + " ");
	      }
	      sc.close();
	}

}
