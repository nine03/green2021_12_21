package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;

public class Day10Ex11x2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("���� �Է��ϼ���(1~12)>>"); 
		Scanner m = new Scanner(System.in); 
		int num = m.nextInt(); 
		switch(num) 
		{ 
		case 3: 
		case 4: 
		case 5: 
				out.println("��"); 
				break; 
					case 6: 
					case 7: 
					case 8: 
							out.println("����"); 
							break; 
								case 9: 
								case 10: 
								case 11: 
									out.println("����"); 
									break; 
										case 12: 
										case 1: 
										case 2: 
											out.println("�ܿ�"); 
											break; 
											default: 
												out.println("�߸��Է�"); 
															} 
		m.close();
	}

}
