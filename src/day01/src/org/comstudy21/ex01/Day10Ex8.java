package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		out.println("�� �� (x1,y1), (x2,y2)�� ��ǥ�� �Է��Ͻÿ� >>"); 
		Scanner sc = new Scanner(System.in); 
		int x1 = sc.nextInt(); 
		int y1 = sc.nextInt(); 
		int x2 = sc.nextInt(); 
		int y2 = sc.nextInt(); 
		if ((x1>=100 & x1<=200) && (y1>=100 && y1<=200)) 
		{ 
			out.println("�簢���� ��ħ"); 
			}
		else if((x2>=100 && x2<200) && (y2>=100 && y2<=200)) 
		{ 
			out.println("�簢���� ��ħ"); 
			}else if(x1<=100 && x2>=200 && y1<=100 && y2>=200) 
			{ 
				out.println("�簢���� ��ħ"); 
				} else 
					out.println("�簢���� �Ȱ�ħ"); 
		sc.close();
	}

}
