package org.comstudy21.ch03;

public class test2 {

	public static void main(String[] args) {
					// ---- 보너스 게임 ----
					// 1   2   3   4   5
					// 16  17  18  19  6
					// 15  24  25  20  7
					// 14  23  22  21  8
					// 13  12  11  10  9
		int[][] arr = new int[5][5];
        
        int print = 5; // k(도형)가 채워지는 개수
        int k = 1;  // 1 ~ 25까지 
        int right = -1; // 오른쪽 방향으로 채운다.
        int bottom = 0; // 아래 방향으로 채운다.
        int top = 1; // top 방향의 반전  right -> left로 bottom -> top으로 
        
        for(int i=5; i>0; i--) {
            
            for(int j=0; j<print; j++) {
                right += top;
                arr[bottom][right] = k;
                k++;
            }
            
            print--;
            
            for(int j=0; j<print; j++) {
                bottom += top;
                arr[bottom][right] = k;
                k++;
            }
            
            top = top * (-1);
        }
        
        // 출력
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
        	    System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
	}

}
