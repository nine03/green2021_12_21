package day14;

import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int size = 0;
		while(true) {
			try {
				System.out.print("ũ���Է�(Ȧ����)>>>");
				size = sc.nextInt();
				break;
			} catch(Exception e) {
				System.out.print("���ڸ� �Է��ϼ���!");
				sc.next();
				continue;
			}
		}
			for(int i =0; i <5;i++) {
				for(int j =0; j<5;j++) {
					if((i == 0)||(i == size - 1)||(j==i))
					{
						System.out.print("*");
					}else if((j == 0)||(j == size - 1))
						System.out.print("^");
					
				}
				System.out.println();
			}

	}

}

