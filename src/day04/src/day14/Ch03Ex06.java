package day14;

import java.util.Arrays;
import java.util.Scanner;

public class Ch03Ex06 {

	public static void main_note(String[] args) {
		// 1���迭 
		// �迭�̶�?
		
		// �ڹ��� �迭���� �߰�ȣ{ } ���.
		// �迭�� Ÿ���� �迭 Ÿ��.
		// �迭 ������Ʈ�̴�.
		
		
		// ��Ʈ�� �迭 Ÿ�� - Ư��Ÿ�Կ� ��������� ���̸� �迭 Ÿ�Եȴ�.
		String[] a;
		// ��Ʈ �迭 Ÿ��
		int[] b;  
		// char 2����Ʈ������ ��� �迭�� ���������� ������ �����ϴ� 4����Ʈ�̴�.
		// �������� ��� �����̴�.
		// �迭�� ������Ʈ�̹Ƿ� ������ ���������� �ȴ�.
		char[] c;

	}
	public static void main00(String[] args) {
		// �迭 ����� ���ÿ� �ʱ�ȭ �ϱ�
		// �迭 ���ͷ�
		int[] arr = {10, 20, 30, 40};
		
		arr[1] = 5000; //�����Ҽ��ְ� �����Ҽ����ִ�
		
		//�迭 ���
		System.out.println(Arrays.toString(arr));
		
		// �ݺ����� �̿��ؼ� �迭 ���
		// �迭�� ù��° ����� ÷�ڴ� 0�̰� 
		//�迭�� ������ ����� ÷�ڴ� �迭ũ�� -1�̴�.
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("arr[arr.length-1] ===> " + arr[arr.length-1]);
	}
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// �Լ��� ���ڷ� �迭�� ������ ���ÿ� ���� �Ҷ� ���.
		//main00(new String[]{"aa","bb","ccc"}); 
		
		// ��¥ �������� �ƴ� �迭 ������ ����
		int[] days;
		// �迭 ���� �Ŀ� �迭�� �����ϱ� - new �����ڸ� ����ؾ��Ѵ�.
		days = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		//System.out.println(days.length);
		System.out.printf("1���� %d�����Դϴ�.\n",days.length);
		
		System.out.println("�� �Է�>>> ");
		int month = scan.nextInt();
		
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
		int day = scan.nextInt();
		
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
			day = scan.nextInt();
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
		int monthBox = month;
		for(total=days[monthBox-1]-day;total<=100;total+=days[monthBox++]) {
			
			if(monthBox == 12) { //12���� ������ 1����
				monthBox = 0;
			}
		}
		System.out.printf("%d�� %d���� 100�� �Ĵ� %d�� %d�� �Դϴ�\n",month,day,monthBox,days[monthBox-1]-(total-100));
		
		// ����4 : Ȯ�� �غ��� - 100�� ���� ��¥�� 200�� 300�� Ư�� ���� ����ǰ��ϼ���.
		System.out.printf("%d�� %d�Ͽ��� ��ĥ ���� ��¥�� ǥ�� �ұ��? >> ",month,day);
		int num = scan.nextInt();
		monthBox = month;
		for(total =days[monthBox-1]-day;total<=num;total+=days[monthBox++]) {
			if(monthBox == 12) {
				monthBox = 0;
			}
		}
		System.out.printf("%d�� %d���� %d�� �Ĵ� %d�� %d�� �Դϴ�\n",month,day,num,monthBox,days[monthBox-1]-(total-num));
	}
}
