package org.comstudy21.ch03;

public class test2 {

	public static void main(String[] args) {
					// ---- ���ʽ� ���� ----
					// 1   2   3   4   5
					// 16  17  18  19  6
					// 15  24  25  20  7
					// 14  23  22  21  8
					// 13  12  11  10  9
		int[][] arr = new int[5][5];
        
        int print = 5; // k(����)�� ä������ ����
        int k = 1;  // 1 ~ 25���� 
        int right = -1; // ������ �������� ä���.
        int bottom = 0; // �Ʒ� �������� ä���.
        int top = 1; // top ������ ����  right -> left�� bottom -> top���� 
        
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
        
        // ���
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
        	    System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
	}

}
