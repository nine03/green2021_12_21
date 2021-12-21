package org.comstudy21.ch03;

public class test4 {

static int[][] arr = new int[5][5]; // 5행 5열 만들기 
	
	private static void printArr(int[][] arr) {
		// 행렬로 출력한다.
		for(int i =0; i<arr.length;i++) {
			for(int j=0;j<arr.length; j++) {
				System.out.print(arr[i][j]==0?"\t" : arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main00(String[] args) { //00
				// ---- 과제 ----- 
				// 1	2	3	4	5
				//		6	7	8	
				//			9	
				// 		10	11	12
				//	13	14	15	16	17
		int num = 1;
		for(int i =0; i<arr.length; i++) {
			int start = i <= 2 ?i: 4-i;
			int end = i <= 2 ? 4-i: i;
			for(int j =start; j<=end; j++) {
				arr[i][j] = num++;
			}
		}
		printArr(arr);
	}
	public static void main06(String[] args) { //01
		// ---- 보너스 게임 ----
		// 1   2   3   4   5
		// 16  17  18  19  6
		// 15  24  25  20  7
		// 14  23  22  21  8
		// 13  12  11  10  9
	
	
	printArr(arr);
	}
}
