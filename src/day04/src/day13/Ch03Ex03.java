package day13;

import java.util.Scanner;

public class Ch03Ex03 {
	static Scanner scan = new Scanner(System.in);

	public static void main00(String[] args) {
		// break label
		
		//�����ϸ� 10 * 10 = 100�� 
	aaa : for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				if(j % 3 == 0 ) break aaa; // 3�� ��� 20�� break���̺��� ���� 1�� break continue �Ȱ���
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
		
	}
	
	//break continue ����
	public static void main(String[] args) { 
		int age = 0;
		
		while(true) {
			try {
				System.out.print("���� �Է�: ");
				age = scan.nextInt();
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace(); 
				System.out.print("�Է� ����! �ٽ� ");
				scan.next(); // scan�� ���ۿ��� \n�� �����Ѵ�.
				continue;
			}
		}
		
		if(age < 20) {
			System.out.println("�̼����ڿ��Դ� ���� ���� �ʽ��ϴ�.");
		} else {
			System.out.println("���ְ� �弼��!");
		}
	}

}
