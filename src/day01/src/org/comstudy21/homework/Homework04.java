package org.comstudy21.homework;

import java.util.Scanner;

public class Homework04 {
	public static final Scanner scan = new Scanner(System.in);
	public static final String ���� = "����";
	public static final String ���� = "����";
	public static final String �� = "��";
	
			// ���������� ����
			// �Լ� �̿� 
	public static String getUserWord(String user) {
		String var = ""; // ���������� �ʱ�ȭ�� �ؾ��Ѵ� 
		do {
			System.out.println("���� ���� ���߿� �Է� �ϼ���!");
			System.out.printf("%s >>" , user);
			var = scan.next();
			System.out.println("var => " + var);
		} while(!(var.equals(����) || var.equals(����) || var.equals(��))); // ��ȿ�� üũ
		System.out.println("�Է� ����!");
		return var;
	} // end of getUserWord

	public static void game(String user1Name, String user2Name ) { // main ��Ʈ�� + ���������� 
		String user1 = getUserWord(user1Name);
		String user2 = getUserWord(user2Name);
		
		if(user1.equals(user2)) {
			System.out.println("�����ϴ�!");
			return;
		}
		
		String win = "";
		switch(user1) {
		case ���� : win = user2.equals(����) ? user2Name : user1Name; break;
		case ���� : win = user2.equals(��) ? user2Name : user1Name; break;
		case ��  : win = user2.equals(����) ? user2Name : user1Name; break;
		}
		System.out.println(win +  "�̰� �̰���ϴ�.");
	}
	public static void main(String[] args) {
		if(args == null || args.length == 0) {
			System.out.println("argument�� �����ϴ�!");
			return;
		}
		while(args[0] != null && args[1] != null) {
			game(args[0], args[1]);
			System.out.println("��� �Ͻðڽ��ϱ�?(y/n) >>");
			char isLoop = scan.next().charAt(0);  // �ݺ� �Ұ���? �Ǿտ� �ִ°� �̴´�
			while(!(isLoop == 'n' || isLoop == 'y'  )) {
				System.out.println("y�Ǵ� n�� �Է��ϼ���!");
				System.out.println("��� �Ͻðڽ��ϱ�?(y/n) >>");
				isLoop = scan.next().charAt(0);
			}
			if(isLoop == 'n') {
				break;
			}
		}
	}
}
