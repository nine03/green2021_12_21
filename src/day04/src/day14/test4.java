package day14;

import java.util.Arrays;
import java.util.Scanner;

public class test4 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		// ��¥ �������� �ƴ� �迭 ������ ����
		int[] days;
		// �迭 ���� �Ŀ� �迭�� �����ϱ� - new �����ڸ� ����ؾ��Ѵ�.
		days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		//System.out.println(days.length);
		System.out.printf("1���� %d�����Դϴ�.\n",days.length);
		
		System.out.println("�� �Է�>>> ");
		int month = sc.nextInt();
		
		int total = 0; 
		// �Էµ� ���� ��¥�� ���ϱ������� ����϶�.
		// 1���� 365���Դϴ�. (days�� ��� ��¥�� total�� �����ؼ� ����Ѵ�.)
		// days[1]  ==== 2���� ��¥�� 
		// days[month-1] ==== �Է¹��� ���� ��¥
		System.out.printf("%d���� %d�ϱ��� �ִ�.\n",month,days[month-1]);
		
		for(int i=0; i<days.length; i++) {
			total = total + days[i];
		}
		System.out.printf("1���� %d���Դϴ�.\n",total);
		
		// ��¥�Է�
		System.out.println("�� �Է�>>> ");
		int day = sc.nextInt();
		
		total = day;
		for(int i=0;i<month-1;i++) {
			total += days[i];  //�����̵ȴ�
		}
		
		System.out.printf("1�� 1�� ���� %d�� %d�ϱ����� %d���� ������.\n",month,day,total);
		// ���� : ��¥�Է� ��ȿ�� üũ ����.
		//  1��1�Ϻ��� �Է¹��� ��/�ϱ��� ������ �������ϴ�.
		while(days[month-1]<0||days[month-1]<day) {
			System.out.printf("�߸� �Է��߽��ϴ�. %d���� ���ڴ� %d �ϱ��� �Դϴ�.\n",month,days[month-1]);
			System.out.println("�� �Է�>>> ");
			day = sc.nextInt();
		}
		total = day;
		for(int i = 0;i < month-1; i++) {
			total += days[i];
		}
		System.out.printf("1��1�Ϻ��� %d�� %d�� ������ %d ���� �������ϴ�.\n",month,day,total);
		
		// ����2 : 0��0�Ϻ��� 1���� ���� ��¥�� 00���Դϴ�.
		// (365 - total ���� ����)
		
		total = 0;
		for(int i = month; i < 12; i++) {
			total += days[i];
		}
		total += days[month-1]-day;
		System.out.printf("%d�� %d�� ���� 12�� 31�ϱ����� %d ���� ���ҽ��ϴ�.\n",month,day,total);
		
		total = 0;
		
		// ����3 : �Է� ��/���� 100�� ���� ��¥ ���.
				int month1 = month;
				for(total=days[month1-1]-day;total<=100;total+=days[month1++]) {
					
					if(month1 == 12) { //12���� ������ 1����
						month1 = 0;
					}
				}
				System.out.printf("%d�� %d���� 100�� �Ĵ� %d�� %d�� �Դϴ�\n",month,day,month1,days[month1-1]-(total-100));
				
				// ����4 : Ȯ�� �غ��� - 100�� ���� ��¥�� 200�� 300�� Ư�� ���� ����ǰ��ϼ���.
				System.out.printf("%d�� %d�Ͽ��� ��ĥ ���� ��¥�� ǥ�� �ұ��? >> ",month,day);
				int num = sc.nextInt();
				month1 = month;
				for(total =days[month1-1]-day;total<=num;total+=days[month1++]) {
					if(month1 == 12) {
						month1 = 0;
					}
				}
				System.out.printf("%d�� %d���� %d�� �Ĵ� %d�� %d�� �Դϴ�\n",month,day,num,month1,days[month1-1]-(total-num));

	}

}
