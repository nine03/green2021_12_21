package day13;

import java.util.Scanner;
import static java.lang.System.out;

public class test4 {

	static Scanner sc = new Scanner(System.in);
	
	static int getDan(String message) {
		out.printf(message);
		int dan = sc.nextInt();
		
		// ��ȿ�� �˻�
		while(dan < 2 || dan > 9) {
			out.println("�Է¹����� �ʰ��߽��ϴ�!");
			out.print(message);
			dan = sc.nextInt();
		}
		return dan;
	}
	
	public static void main(String[] args) {
		//����1 : 3�� 3���� ������ ��� 
		//����2 : ���۴�, ����� ��ɰ� ��ü�ϼ���
		int startDan = 2;
		int endDan = 9;
		
		startDan = getDan("���۴� �Է�>>");
		endDan = getDan("����� �Է�>>");
		
		//ġȯ�ϱ�
		if(startDan > endDan) {
			int temp = startDan;
			startDan = endDan;
			endDan = temp;
		}
		for(int dan =startDan; dan <= endDan; dan+=3) { // �� 2 ~ 9
			for(int i = 0; i < 3; i++) {  // ���η� 3���� ��� 
				if(dan + i < endDan + 1) {  
				out.printf("***%d***\t",dan+i);	
				}
			}
			out.println();
			for(int cnt = 1; cnt <= 9; cnt++) { //�� 1 ~ 9
				for(int i = 0; i < 3; i++) { // ���η� 3���� ��� 
					if(dan + i < endDan + 1) {
						out.printf("%dx%d=%d\t",dan+i,cnt,(dan+i)*cnt);
					}
				}
				out.println();
			}

		}
		
	}

}
