package day13;

import static java.lang.System.out;

public class test3 {

	public static void main(String[] args) {
		//����1 : 3�� 3���� ������ ��� 
		//����2 : ���۴�, ����� ��ɰ� ��ü�ϼ���.
		for(int dan = 2; dan <= 9; dan+=3) { // �� 2 ~ 9
			for(int i = 0; i < 3; i++) {  // ���η� 3���� ��� 
				if(dan + i != 10) {  
				out.printf("***%d***\t",dan+i);	
				}
			}
			out.println();
			for(int cnt = 1; cnt <=9; cnt++) { //�� 1 ~ 9
				for(int i = 0; i < 3; i++) { // ���η� 3���� ��� 
					if(dan + i != 10) {
						out.printf("%dx%d=%d\t",dan+i,cnt,(dan+i)*cnt);
					}
				}
				out.println();
			}
		}
	}
}


