package org.comstudy21.levelup;

import java.util.Scanner;

public class test {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// ����� ���α׷� 
		// - �� �Ǵ� ������ �ݺ��ѹ��� �Ѱ��� ���
		//	*********
		//	**** ****
		//	***   ***
		//	**     **
		//	*       *
		//	**     **
		//	***   ***
		//	**** ****
		//	*********
		
		int size = 0;
		while (true) {
			try {
				System.out.print("ũ���Է�(Ȧ����)>>> ");
				size = scan.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է� �ϼ���!");
				scan.next();
				continue;
			}
		}
		// ��ȿ�� �˻� : 5�̻� 15���� ���� ���, Ȧ���� �Է� ������.
		while(size%2==0 || (size < 5 || size >15)) {
			try {
				if(size < 5 || size >15){
					System.out.println("5�̻� 15���� ���� �Է��ϼ���!");
					System.out.print("ũ���Է�(Ȧ����)>>> ");
					size = scan.nextInt();
					continue;
				}
				System.out.println("Ȧ���� �Է� �ϼ���!");
				System.out.print("ũ���Է�(Ȧ����)>>> ");
				size = scan.nextInt();
			} catch (Exception e) {
				System.out.println("���ڸ� �Է� �ϼ���!");
				scan.next();// k\n
				size = 0;
				continue;
			}
		}
		
		int end = size/2 + 1;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(j>=end && j<size-end? " " : "*");
			}
			System.out.println();
			end = i<size/2 ? end-1:end+1;
		}
	}
}
