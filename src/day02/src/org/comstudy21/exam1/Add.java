package org.comstudy21.exam1;

public class Add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int sum=0;
	      for(int i=0; i<args.length; i++) {
	         try {
	            sum += Integer.parseInt(args[i]);
	         }catch(NumberFormatException e) {
	            continue;
	         }
	      }
	      System.out.println(sum);
	}

}
