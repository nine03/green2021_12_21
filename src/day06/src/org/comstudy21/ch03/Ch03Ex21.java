package org.comstudy21.ch03;

public class Ch03Ex21 {

	public static void main(String[] args) {
		
		//초기화
		int[] arr = {10,30,40,90,120,50};
		
		for(int number: arr) {
			System.out.println("number => " + number);
		}
		System.out.println("--------------------------");
		for(int i = 0; i < arr.length; i++) {
			int number = arr[i];
			System.out.println("number =>" + number);
		}
	} 

}
