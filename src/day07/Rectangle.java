package day07;

import java.util.Scanner;

public class Rectangle {
	int width;
	int height;
	
	public int getAreat() {
		return width * height;
	}

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(); // 객체 생성
		Scanner sc = new Scanner(System.in);
		System.out.print(">> ");
		
		rect.width = sc.nextInt();
		rect.height = sc.nextInt();
		
		System.out.println("사각형의 면적은 " + rect.getAreat());
		
		sc.close();

	}

}
