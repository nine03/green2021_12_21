package org.comstudy21.homework;

import java.util.Scanner;
 
public class Homework02 {
	
	public static final Scanner scan = new Scanner(System.in);
	
	public static boolean inRect(int x, int y, int rectx1, int rectx2, int recty1, int recty2) {
		if( (x >= rectx1 && x <= recty2) && (y >= recty1 && y <= recty2)) {
			return true;
		}
		return false;
	}
	// 2�� �������� 8��
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x1 = 100, x2 = 200, y1 = 100, y2 = 200;
		System.out.println("��(x1,y1)�� ��ǥ�� �Է��Ͻÿ�>>");
		int nx1 = scan.nextInt();
		int ny1 = scan.nextInt();
		System.out.println("��(x2,y2)�� ��ǥ�� �Է��Ͻÿ�>>");
		int nx2 = scan.nextInt();
		int ny2 = scan.nextInt();
		//int ny3 = scan.nextInt();
		scan.close();
		
		if(inRect(nx1, ny1,x1,x2,y1,y2) && inRect(nx2,ny2,x1,x2,y1,y2)) {
			System.out.println("�浹 ����!");
		} else {
			System.out.println("�浹 ����!");
		}

}

	// 2�� �������� 7�� �浹�˻� (���Ӱ����Ҷ� �������ؾ��Ѵ�.)
	public static void main00(String[] args) {
		// TODO Auto-generated method stub
		int x1 = 100, x2 = 200, y1 = 100, y2 = 200;
		System.out.println("��(x1,y1)�� ��ǥ�� �Է��Ͻÿ�>>");
		int nx1 = scan.nextInt();
		int ny1 = scan.nextInt();
		System.out.println("��(x2,y2)�� ��ǥ�� �Է��Ͻÿ�>>");
		int nx2 = scan.nextInt();
		int ny3 = scan.nextInt();
		scan.close();
		
		// x�� x1�� x2���̿� �ְ� y�� y1�� y2���̿� �ִ°�?
	 //	if((x >= x1 && x <= x2) && (y > y1 && y <= y2)) {
	 //		System.out.println("�簢�� �ȿ� �ֽ��ϴ�!");
	 //	} else {
		//	System.out.println("�簢�� �ȿ� �����ϴ�.");
		//}
	}

}
