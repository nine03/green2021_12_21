package org.comstudy21.exam1;

import java.util.Scanner;
import java.util.InputMismatchException;


public class Multiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner scanner = new Scanner(System.in);
	        while(true) {
	           System.out.print("���ϰ��� �ϴ� �� �� �Է� >> ");
	           try {
	              int n = scanner.nextInt();
	             int m = scanner.nextInt();
	              System.out.print(n + "x" + m + "=" + n*m);
	              break;
	           }catch(InputMismatchException e) {
	              System.out.println("�Ǽ��� �Է��ϸ� �ȵ˴ϴ�.");
	              scanner.nextLine();
	           }
	        }
	        scanner.close();

	}

}
