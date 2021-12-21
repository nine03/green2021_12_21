package org.comstudy21.exam1;

public class Day11Ex7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n [] = new int[10];
		
		for(int a = 0; a < n.length; a++) {
			int i = (int)(Math.random() * 10 + 1);
			n[a] = i;
		}
		int sum = 0;
		for(int a = 0; a < n.length; a++)
			sum += n[a];
		System.out.print("·£´ýÇÑ Á¤¼öµé : ");
		for(int a = 0; a < n.length; a++)
			System.out.print(n[a] + " ");
		System.out.println("\nÆò±ÕÀº " + (double)sum / n.length);
	}

}
