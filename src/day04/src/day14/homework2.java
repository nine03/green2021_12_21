package day14;

import java.util.Scanner;

public class homework2 {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int size = 0;
		while(true) {
			try {
				System.out.print("ũ���Է�(Ȧ����)>>>");
				size = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("���ڸ� �Է� �ϼ���!");
				sc.next();
				continue;
			}
		}
		
		while(size % 2 == 0 || (size  < 5 || size > 15)) {
			try {
				if(size < 5 || size > 15) {
					System.out.println("5�̻� 15���� ���� �Է��ϼ���!");
					System.out.print("ũ���Է�(Ȧ����)>>>");
					size = sc.nextInt();
					continue;
				}
				System.out.println("Ȧ���� �Է� �ϼ���!");
				System.out.println("ũ���Է�(Ȧ����)>>>");
				size = sc.nextInt();
			}  catch(Exception e) {
				System.out.println("���ڸ� �Է� �ϼ���!");
				sc.next();
				size = 0;
				continue;
			}
		}
		int end = size / 2+1;
		for(int i = 0; i < size; i++) {
			for(int j =0; j < size; j++) {
				System.out.print(j>= end && j < size - end ? " " : "*");
			}
		System.out.println();
		end = i < size / 2 ?  end - 1 : end + 1;
		}
	}

}
