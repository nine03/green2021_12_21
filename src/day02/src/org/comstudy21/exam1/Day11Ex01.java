package org.comstudy21.exam1;

import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.out;

public class Day11Ex01 {
	//public static Scanner scan = new Scanner(System.in); ��ĳ�ʴ� �ɷ����� ���Ѵ�.
	public static int getNum() {
		int num = 0; // ������ ����� ������ �ʾҴ�. �����϶��� 
		int ch = 0;
		try {
			while((ch = System.in.read()) != '\n') {
			 if(ch >= '0' && ch <= '9') {
			 num = num * 10 + ch - '0';  // 0  48�� �ƽ�Ű�ڵ� 0�̴� ���ڸ� ������ ���ڰ� ���ڷ� �ٲ㼭 �����  
			 
			 }
			}
		} catch (IOException e) {}
		return num;
	}
	
	public static void main(String[] args) {
		// ���� 3���� �Է� �޾Ƽ� ū��, �߰�, �������� �Ǻ��ϴ� ���α׷�.
		int a, b, c; // ���������� �ʱ�ȭ�� �ʿ��ϴ�
		int max = 0, mid = 0, min = 0;
		
		out.print("����1 �Է� >>> ");
		a = getNum(); // ���͸� �ľߵ� �پ�� �ȵ� 
		out.print("����2 �Է� >>> ");
		b = getNum();
		out.print("����3 �Է� >>> ");
		c = getNum();
		
		out.printf("%d, %d, %d\n",a, b, c);
		//-35�� ������ ������ ���Ϳ��� ģ���� ����
		
		//������ ,�ݺ��� �������� if�� ���� 
		if(a>b) {
			if(a>c) {
				max = a;
				if(b<c) {
					mid = c; min = b;
				}else {
					mid = b; min = c;
				}
			}else {
				max = c;
				if(a<b) {
					mid = b; min = a;
				}else {
					mid = a; min = b;
				}
			}
		}else {
			if(b>c) {
				max = b;
				if(a<c) {
					mid = c; min = a;
				}else {
					mid = a; min = c;
				}
			} else {
				max = c;
				if(a<b) {
					mid = b; min = a;
				}else {
					mid = a; min = b;
				}
			}
		}

		
		out.println("���� ū���� " + max); 
		out.println("���� �������� " + min);
		out.println("�߰� ���� " + mid);
	}

}
