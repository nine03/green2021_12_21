package day14;

import java.util.Scanner;

public class test5 {

	static int[] days = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
	static Scanner sc = new Scanner(System.in);
	static int month = 0;
	static int day = 0;
	static int total = 0;
	static int rd = 0;
	 int day100 = 0;
	 
	 public static int getMonth() {
		 while(true) {
			 try {
				 System.out.print("���ϴ� ���� �Է��ϼ��� >>");
				 month = sc.nextInt();
				 break;
			 } catch (Exception e) {
				 System.out.println("�Է¿� �����߽��ϴ�.");
				 System.out.println("���ڸ� �Է����ּ���.");
				 sc.next();
				 continue;
			 }
		 }
		 return month;
	 }
	 
	 public static int getDay() {
		 while(true) {
			 try {
				 System.out.print("���ϴ� ��¥�� �Է��ϼ��� >>");
				 day = sc.nextInt();
				 break;
			 } catch(Exception e) {
				 System.out.println("�Է¿� �����߽��ϴ�");
				 System.out.println("���ڸ� �Է����ּ���.");
			 }
		 }
		 return day;
	 }
	public static void main(String[] args) {
		
		getMonth();
		while(month > 12 || month <= 0) {
			try {
				System.out.println("�Է¿� �����߽��ϴ�.");
				System.out.println("1~12�� ���� �߿� �Է��ϼ���");
				System.out.print("���� �Է� >>");
				month = sc.nextInt();
				continue;
			}catch (Exception e) {
				System.out.println("�Է¿� �����߽��ϴ�.");
				System.out.println("���ڸ� �Է����ּ���.");
				sc.next();
				continue;
			}
		}
		
		getDay();
		while(day > days[month -1] || day <= 0) {
			try {
				System.out.println("�Է¿� �����߽��ϴ�.");
				System.out.printf("1~%d�� ���� �߿� �Է��ϼ���.\n",days[month - 1]);
				System.out.print("���� �Է� >>");
				day = sc.nextInt();
				continue;
			} catch(Exception e) {
				System.out.println("�Է¿� �����߽��ϴ�.");
				System.out.println("���ڸ� �Է����ּ���.");
				sc.next();
				continue;
			}
		}
		
		for(int i = 0; i < days.length; i++) {
			total += days[i];
		}
		System.out.printf("1���� %d���Դϴ�.\n",total);
		System.out.printf("�Է��Ͻ� %d ���� %d�ϱ��� �Դϴ�.\n",month,days[month - 1]);
		System.out.println();
		
		total = 0;
		for(int i = 0; i < month - 1; i++) {
			total += days[i];
			rd = total + day;
		}
		System.out.printf("1�� 1�Ϻ��� %d�� %d�� ������ %d���� �������ϴ�. \n",month,day,rd + 1);
		System.out.println();
		
		total = 0;
		rd = 0;
		
		for(int i = month - 1; i < days.length; i++) {
			total += days[i];
			rd = total - day;
		}
		
		System.out.printf("%d�� %d�Ϻ��� 1���� ���� ��¥�� %d ���Դϴ�.\n",month,day,rd);
		System.out.println();
		
		int countDay;
		int count = 0;
		int dMonth = month;
		int dDay = 1;
		System.out.println("Ư�� ��¥�� �˾ƺ����� �ؿ�.");
		System.out.print("���� ���� ��¥�� �˾ƺ����? >>");
		countDay = sc.nextInt();
		System.out.printf("%d�� ���� ��¥�� ����մϴ�.\n",countDay);
		total = 0;
		
		int tempDay = day;
		for(int i = 0; i < countDay; i++) {
			tempDay++;
			if(dMonth == 2 && tempDay > days[1]) {
				tempDay = 1;
				dMonth++;
				if(dMonth > days.length) {
					dMonth = 1;
				}
			}else if(dMonth == 1 && tempDay > days[0])
				tempDay = 1;
				dMonth++;
				if(dMonth > days.length) {
					dMonth = 1;
				}else if(dMonth == 3 && tempDay > days[2]) {
					tempDay = 1;
					dMonth++;
					if(dMonth > days.length) {
						dMonth = 1;
					}
				}else if(dMonth == 4 && tempDay > days[3]) {
					tempDay = 1;
					dMonth++;
					if(dMonth > days.length) {
						dMonth = 1;
					}
				}
		}
	}

}
