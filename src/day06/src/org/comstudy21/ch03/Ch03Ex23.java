package org.comstudy21.ch03;

import java.util.Arrays;
import java.util.Scanner;

public class Ch03Ex23 {
	
	static Scanner scan = new Scanner(System.in);
	public static void main01(String[] args) {
		int[] score = {95, 70, 85, 90, 100, 45, 35, 85, 70, 75};
		
		// 65�� �Է� �޾Ƽ� 65�� ������ true �ƴϸ� false ���.
		// �˻� �� ���� >> 65
		// ��� 65�� �迭�� �����ϴ�.
		// 1. ������ �Է� �޴´�.
		// 2. �Է¹��� ������ �迭�� �ִ°�? �˻�
		// 3. �ִٸ� count�Ѵ�.
		
		int ea = 0;
		int keyNum = 0; // �˻��� ��ȣ 
		System.out.print("�˻� �� ���� >>");
		keyNum = scan.nextInt();
		for(int i =0; i<score.length; i++) {
			if(keyNum == score[i]) {
				ea++;
			}
		}
		//4. �˻� ���� �� ��� ���
		if(ea == 0) {
			System.out.printf("��� : %d�� �迭�� �����ϴ�!",keyNum);
		} else {
			System.out.printf("��� : %d �迭�� %d�� �ֽ��ϴ�!",keyNum,ea);
		}
		
	}
	
	public static void main02(String[] args) {
		// �迭�� ������ �Է� �޾Ƽ� ���� ū ������ ���� ���� ������ ���
		int[] score = new int[5]; // 5���� �Է¹޴´�.
		int max = 0, min = 100;
		
		for(int i =0; i<score.length; i++) {
			System.out.print("���� �Է� " + i + ">> ");
			score[i] = scan.nextInt();
		}
		for(int i = 0; i < score.length; i++) {
			if(max < score[i]) {
				max = score[i];
			}
		}
		for(int i = 0; i < score.length; i++) {
			if(min > score[i]) {
				min = score[i];
			}
		}
		System.out.println("ū ���� :" + max);
		System.out.println("���� ���� :" + min);
	} 
	//public static void main03(String[] args) { //03
		
	//}
	public static void main04(String[] args) { //04
		int[] score = {65, 100, 75, 80, 35, 90};
		int[] rank = new int[score.length];
		
		// ��� : [5,1,4,3,6,2]   65,100,75,80,35,90
		// 0. socre��ŭ �ݺ��ϸ鼭 ...
		// 1. rank[i] ��°�� 1�� �����Ѵ�.
		// 2. score[i]��°���� ū ���� ��Ұ� �ִٸ� rank[i]�� �����Ѵ�.
		//    (���� �迭�� ��ҳ��� ���ϱ�)
		// �غ��⳪ �߾�? - ���ֿ�
		
		int size = score.length; // size�� �� �̷��� ����ϸ� �������� ? ���ھ� �� �ִ� ��� �� 
		
		
		for(int i =0;i<size; i++) {
			rank[i] = 1;
			for(int j =0; j<size;j++) {
				if(score[i]<score[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
	}
	public static void main05(String[] args) { //05
		int[] score = {65, 100, 75, 80, 35, 90};
		int[] rank = new int[score.length];
		
		// ��� : [5,1,4,3,6,2]   65,100,75,80,35,90
		// 0. socre��ŭ �ݺ��ϸ鼭 ...
		// 1. rank[i] ��°�� 1�� �����Ѵ�.
		// 2. score[i]��°���� ū ���� ��Ұ� �ִٸ� rank[i]�� �����Ѵ�.
		//    (���� �迭�� ��ҳ��� ���ϱ�)
		// �غ��⳪ �߾�? - ���ֿ�
		
		int size = score.length; // size�� �� �̷��� ����ϸ� �������� ? ���ھ� �� �ִ� ��� �� 
		
		
		for(int i =0;i<size; i++) {
			rank[i] = 1;
			for(int j =0; j<size;j++) {
				if(score[i]<score[j]) {
					rank[i]++;
				}
			}
		}
		for(int i =0; i<score.length; i++) {
			System.out.printf("%d���� %d���Դϴ�.\n",score[i],rank[i]);
		}
	}
	public static void main(String[] args) { //06
		int[] score = {95, 70, 85, 90, 100, 45, 35, 85, 70, 75};
		
		// ���� �˻� : 70
		// ��� : 70�� 1��° 8��°�� �ֽ��ϴ�.
		// 70�� 2�� 8������ ã�ҽ��ϴ�. �����Ͻðڽ��ϱ� ?
		
		// 1. �˻��� �Է� �ޱ�
		// 2. score�� ��Ҹ�ŭ �ݺ�
		// 3. �˻���� ���� ���� �ִٸ� ��ġ ���
		System.out.print("���� �˻� : ");
		int keyWord = scan.nextInt();
		System.out.printf("��� : %d��",keyWord);
		boolean flag = false;
		for(int i =0; i <score.length; i++) {
			if(keyWord == score[i]) {
			System.out.print(" "+ i +"��°");
			flag = true;
			}
		}
		if(flag) {
		System.out.println("�� �ֽ��ϴ�.");
		}else {
			System.out.println(" �����ϴ�.");
		}
	}
}
