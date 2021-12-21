package org.comstudy21.ch03;

public class test3 {
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

	public static void main(String[] args) {
		// ---- 과제 ----- 
		// 1	2	3	4	5
		//		6	7	8	
		//			9	
		// 		10	11	12
		//	13	14	15	16	17
		int num = 1;
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i<=2? i: 4-i; j <arr.length-end; j++) {
				arr[i][j] = num++;
			}
			System.out.println();
			end = i < 2? end+1 : end -1;
		}
		printArr(arr);
		
	}
	}
