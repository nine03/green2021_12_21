package org.comstudy21.ch03;

public class test1 {

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
				// --- 과제 ----
				// 1  2  3  4  5
				//    6  7  8
				//       9
				//   10  11 12
				//13 14  15 16 17
		int num = 1;
		for(int i = 0; i < arr.length; i++) {
			if(i<=(arr.length)/2) {
				for(int j = i; j<=4-i; j++) {
					arr[i][j] = num++;
				}
		}else {
			for(int j = 4-i;j<=i;j++) {
				arr[i][j] = num++;
			}
		}

	}
		printArr(arr);
	}

}
