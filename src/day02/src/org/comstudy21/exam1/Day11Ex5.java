package org.comstudy21.exam1;

import java.util.Scanner;

public class Day11Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		
		System.out.print("���� ���� 10���� �Է��Ͻÿ�>>");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("3�� �����");
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 3 == 0) {
				System.out.print(arr[i] + " ");
			}
		}
		sc.close();
	}

}
