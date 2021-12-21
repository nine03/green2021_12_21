package org.comstudy21.exam1;

public class Day11Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		 for (int i=1; i<100; i++) {
	         a = i/10;
	         b = i%10;
	         if((a == 3 || a == 6 || a == 9) && (b ==3 || b == 6 || b == 9) ) {
	            System.out.println(i + "¹Ú¼ö Â¦Â¦");
	         }
	         else if((a == 3 || a == 6 || a == 9) && (b !=3 || b != 6 || b != 9)) {
	            System.out.println(i + "¹Ú¼ö Â¦");
	         }
	         else if((a != 3 || a != 6 || a != 9) && (b ==3 || b == 6 || b == 9)) {
	            System.out.println(i + "¹Ú¼ö Â¦");
	         }
	      }
	}

}
