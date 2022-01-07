package miniproj1.view;

import java.util.Scanner;

public abstract class View {
	public static Scanner sc = new Scanner(System.in);
	public static int choice;
	public abstract void display();
	public void print() {
		System.out.println("-------------------------------------------------");
		System.out.println("이름\t전화번호\t\t이메일");
		System.out.println("-------------------------------------------------");
	}
}
