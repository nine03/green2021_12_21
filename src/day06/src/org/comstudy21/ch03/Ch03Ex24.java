package org.comstudy21.ch03;

import java.util.Arrays;
import java.util.Scanner;

public class Ch03Ex24 {
	//static Scanner scan = new Scanner(System.in);
	
	public static void main00(String[] args) { //00
		
		String[] names = new String[3];
		
		// �̸� 3���� ���������� �Է��ؼ� ����ϱ�
		for(int i =0; i<names.length; i++) {
			System.out.print("���� �Է�"+(i+1)+">> ");
			names[i] = scan.next();
		}
		System.out.println(Arrays.toString(names));
		
		// �˻��� �Է�
		System.out.println("�˻��� �Է� >> ");
		String keyWord = scan.next();
		
		for(int i=0;i<names.length;i++) {
			if((names[i]).indexOf(keyWord) != -1) {
				System.out.println(names[i]);
			}
		} // ���Ե������� �ܾ��̸� -1 ���ԵǸ� ������ �����Բ� 
	}
	
	static Scanner scan = new Scanner(System.in);
	public static void main01(String[] args) { //01
		
		String[] names = {"ȫ�浿","�̼���","������"};  //���� �ʱ�ȭ�� ��Ų��
		int[][] score = {{95,100},{100,95},{80,85}}; //2���� �迭 3 �� 2���� ������ 
		// ����  ���� ���� ���� 
		// ȫ�浿 95 100 195  
		// �̼��� 100 95 195
		// ������ 80 85  165
		
		System.out.println("����\t����\t����\t����\n");
		int size = names.length;
		for(int i=0;i<size;i++) {
			System.out.print(names[i]+"\t");
			int total =0;
			for(int j=0;j<score[i].length;j++) {
				System.out.print(score[i][j] + "\t");
				total += score[i][j];
			}
			System.out.println(total);
		}
 	}
}
