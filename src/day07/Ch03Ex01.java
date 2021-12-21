package day07;

import java.util.Scanner;
import static java.lang.System.out;
import static java.lang.System.in;

public class Ch03Ex01 {

	static Scanner scan = new Scanner(in);
	public static void main(String[] args) {
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
		int month = 0 ,day = 0;
		int total = 0;
		int nextMonth = 0,nextDay = 0;
		
		//��ȿ�� üũ 
		out.print("�� �Է� >>");
		month = scan.nextInt();
		while(month < 1 || month > 12) {
			out.println("�� �Է� ���� : ������ ������ϴ�!");
			out.print("�� �ٽ� �Է�(1~12����) >>");
			month = scan.nextInt();
		}
		out.print("�� �Է� >>");
		day = scan.nextInt();
		while(day < 1 || day > days[month-1]) {
			out.printf("�� �Է� ���� : �ش� ���� ��¥�� %d�ϱ� �Դϴ�.\n",days[month-1]);
			out.printf("��  �ٽ� �Է�(1~%d����) >>",days[month-1]);
			day = scan.nextInt();
			
		}
		
		out.printf("%d���� %d�ϱ��� �ִ�.\n",month,days[month-1]);
		out.printf("%d���� ���� ��¥�� %d���̴�.\n",month,days[month-1] - day); // ���� ���� ��¥ days[month-1] - day
		// 1��1�Ϻ���  �Է³�¥����  total�� ����.
		total = day; // total ���� �ʱ�ȭ �����ش�.
		for(int i = 0; i < month-1; i++) { //1�� 1�Ϻ���  i�� indext ���Ӹ� 
			total += days[i];
		}
		out.printf("1�� 1�Ϻ��� %d�� %d���̱����� %d�� �������ϴ�.\n",month,day,total);
		
		// 1���� ���� ��¥ ���ϱ� 
		total = days[month-1] - day;// total �ٽ� �غ��ϱ� 
		for(int i = month; i < days.length;i++) { // ������ month
			total += days[i];
		}
		out.printf("%d�� %d�� ���� 1���� ���� ��¥�� %d���Դϴ�.\n",month,day,total);
		
		// ���� ���� ���� ��¥�� total �ʱ�ȭ   365  51 + 100   151 1�� ��¥ ��ŭ ���� 2�� ��¥ ��ŭ ���� 3����¥ ��ŭ����
		out.print("���� �� ��¥�� �˰� �ͳ���? >>");
		int dd = scan.nextInt();
		total = dd;
		// ���� ���� ���� ���� ��¥���� ���� ���ڰ� ����� �׳� ������� day + dd�̴�.
		
		total = total - (days[month-1] - day); //total�� �� �ʱ�ȭ�����ش�
		int i = month%12;
		for(; total > days[i] ;i++, i%=12) {// i�� index i�� ���������� ���� ������¥���� month �� 12���� ũ�� 0 �ȴ�   i�� ���� �ϰ� i %= 12
			total -= days[i];
			
		}
		nextMonth = i + 1;
		nextDay = total;
		out.println(dd +"�� �Ĵ� "+ nextMonth +"�� "+ nextDay+"���Դϴ�.\n");
	}

}
