package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;


public class Day10Ex01 {
	static Scanner scan = new Scanner(System.in);
	//�ν��Ͻ� ����� ������ ���ٸ��Ѵ� 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money = 0;
		int price = 240;
		int [] arr = {5000,1000,500,100,50,10};
		
		//int a;
		out.printf("���� ���� %d���Դϴ�. \n", 240);
		out.print("�����Է� : ");
		money = scan.nextInt();
		// ������ ���� ��µǵ��� ���� �ϼ���.(�ݺ��� ��� ����)
		// 10000������ �Է� �޾Ҵٸ� 
		// 5000���� 1��
		// 1000���� 4��
		// 500���� 1��
		// 100���� 2��
		// 50���� 1��
		// 10���� 1��
		//a = money - price;
		//if(a >= 0) {
			//out.print("�ܾ� : " + a + "��");
		//}else {
			//out.print("�ܾ� ���� \n �����ִ� �ܾ��� :" + a + "���Դϴ�.");
		//}
		
		//int t = money / 2;
		//int t1 = t / 5;
		//int t2 = t1 / 2;
		//int t3 = t2 / 5;
		//int t4 = t3 / 2;
		//int t5 = t4 / 5;
		//int t6 = t5 / 10;
 		
		//out.print("\n");
		//out.print("�ܾ� : " + t + "��" );
		//out.print("\n");
		//out.print("�ܾ� : " + t1 + "��");
		//out.print("\n");
		//out.print("�ܾ� : " + t2 + "��");
		//out.print("\n");
		//out.print("�ܾ� : " + t3 + "��");
		//out.print("\n");
		//out.print("�ܾ� : " + t4 + "��");
		//out.print("\n");
		//out.print("�ܾ� : " + t5 + "��");
		//out.print("\n");
		//out.print("�ܾ� : " + t6 + "��");
		//out.print("\n");
		
		int m = (money - price);
		for(int i = 0; i < arr.length; i++) {
			int num = m / arr[i];
				m = m % arr[i];
				out.print(arr[i] + "���� ");
				arr[i] = num;
				out.print(arr[i] + "�� ");
				out.print("\n");
		}

	}

}
