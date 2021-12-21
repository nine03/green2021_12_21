package org.comstudy21.exam1;

public class Day11Ex10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = new int[4][4];
	      int x, y, result=0;

	      while(result < 10) {
	         x = (int)(Math.random()*4); 
	         y = (int)(Math.random()*4); 
	         if(arr[y][x]==0) { 
	            arr[y][x] = (int)(Math.random()*10+1);
	            result++;
	         }
	      }
	      
	      for(int i=0; i<arr.length; i++) {
	         for(int j=0; j<arr[i].length; j++) {
	            System.out.print(arr[i][j]+" ");
	         }
	         System.out.println();
	      }
	}

}
