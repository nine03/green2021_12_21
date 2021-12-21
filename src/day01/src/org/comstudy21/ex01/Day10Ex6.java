package org.comstudy21.ex01;

import java.util.Scanner;
import static java.lang.System.out;


public class Day10Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		out.print("1~99 »çÀÌÀÇ Á¤¼ö¸¦ ÀÔ·ÂÇÏ½Ã¿À>>"); 
		int num = sc.nextInt(); 
		if(num!=0 && num>=1 && num <=99) 
		{ 
			int a,b; 
			a = num / 10; 
			b = num % 10; 
			if((a==3 || a==6 || a==9) && (b==3 || b==6 || b==9)) 
			{ 
				System.out.println("¹Ú¼öÂ¦Â¦"); 
				} else if((a==3 || a==6 || a==9) || (b==3 || b==6 || b==9)) 
				{ 
					out.println("¹Ú¼öÂ¦"); 
					} 
			} else { 
				out.println("¼ıÀÚÀÇ ¹üÀ§¸¦ ¹ş¾î³µ½À´Ï´Ù."); 
				} 
		sc.close();

		
	}

}
