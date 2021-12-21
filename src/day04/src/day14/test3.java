package day14;

import java.util.Scanner;

public class test3 {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int size = 0;
		while (true) {
			try {
				System.out.print("ũ���Է�(Ȧ����) >>> ");
				size = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է��ϼ���!");
				sc.next();
				continue;
			}
		}
		// ��ȿ�� �˻� : 5���� ũ�� 15���ٴ� ���� ���� ���, Ȧ���� �Է� ������
		while((size < 5 || size > 15) || size % 2 == 0) {
			try {
				if(size < 5 || size > 15) {
					System.out.println("5�̻� 15���� ���� �Է��� �ּ���!");
					System.out.printf("ũ���Է�(Ȧ����) >>> ");
					size = sc.nextInt();
					continue;
				}
				System.out.println("Ȧ���� �Է��� �ּ���!");
				System.out.printf("ũ���Է�(Ȧ����) >>> ");
				size = sc.nextInt();
			} catch (Exception e) {
				System.out.println("���ڸ� �Է��ϼ���!");
				sc.next();
				size = 0;
				continue;
			}
		}

		for(int i = 0; i < size; i++) {
			for(int j=0; j < size; j++) {
				System.out.print(i == 0 || i == size - 1 || j == 0 || j == size - 1 ? "*" : i == j ? "*" : " ");	
			}
			System.out.println();
		}	
		System.out.println();
		
		int end = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 0) {
					System.out.print("*");
				} else if (i == size - 1){
					System.out.print("*");
				} else {
					System.out.print((j == 0) || (j == size - 1) || (j == size / 2 - end) || (j == size / 2 + end) ? "*" : " ");
				}
			}
			System.out.println();
			end = i < size / 2 ? end + 1 : end - 1;
		}
		System.out.println();
	}
}
