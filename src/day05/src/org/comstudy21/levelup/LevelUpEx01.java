package org.comstudy21.levelup;

import java.util.Scanner;

public class LevelUpEx01 {

	public static void main_target(String[] args) {
		// 별출력 프로그램    
		//  - 별 또는 공백이 반복한번에 한개씩 출력
		//
		//          *       1
		//         ***      3
		//        *****     5
		//       *******    7
		//      *********   9
		
		
		
		//      *********
		//       *******
		//        *****
		//         ***
		//          *
		
			//      *       1
		//         ***      3
		//        *****     5
		//       *******    7
		//      *********
		//       *******
		//        *****
		//         ***
		//          *
		
		
		//      *********
		//       *******
		//        *****
		//         ***
		//          *
		//          *       1
		//         ***      3
		//        *****     5
		//       *******    7
		//      *********
		
		//		*********
			//	**** ****
			//	***   ***
			//	**     **
			//	*       *
			//	**     **
			//	***   ***
			//	**** ****
			//	*********	
	}
	public static void main01(String[] args) {
		//  *         : 0행, 별이 1
		//  **        : 1행, 별이 2
		//  ***       : 2행, 별이 3
		//  ****      : 3행, 별이 4
		//  *****     : 4행, 별이 5
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i + 1; j++) { // i가 0이기때문에 
				System.out.print("*");
			}
			System.out.println();
		}
		
//			for(int i = 1; i <= 25; i++) {
//			System.out.print("*");
//			if(i % 5 == 0) {
//			System.out.println();
//			}
//		}

	}
	public static void main02(String[] args) {
		// *****    i : 0   j : 5   j < 5
		// ****     i : 1   j : 4 
		// ***      i : 2   j : 3 
		// **       i : 3   j : 2 
		// *        i : 4   j : 1  
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main03(String[] args) {
		//  *         : 0행, 별이 1
		//  **        : 1행, 별이 2
		//  ***       : 2행, 별이 3
		//  ****      : 3행, 별이 4
		//  *****     : 4행, 별이 5
		 // ****     i : 5   j : 4 
		 // ***      i : 6   j : 3 
		//  **       i : 7   j : 2 
		//  *        i : 8   j : 1  
		// 변수 추가 
		int end = 1;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < end; j++) {
				System.out.print("*");
			}
			System.out.println();
			end = i < 4 ? end+1 : end-1;
		}
	}
	public static void main04(String[] args) {
		//  *         : 0행, 별이 1
		//  **        : 1행, 별이 2
		//  ***       : 2행, 별이 3
		//  ****      : 3행, 별이 4
		//  *****     : 4행, 별이 5
		 // ****     i : 5   j : 4 
		 // ***      i : 6   j : 3 
		//  **       i : 7   j : 2 
		//  *        i : 8   j : 1  
		// 변수 추가 
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main05(String[] args) {
		// ^^^^*
		// ^^^**
		// ^^***
		// ^**** 
		// *****
		for(int i =0; i<5; i++) {
		for(int j = 0; j< 5; j ++) {
			System.out.print(j <4-i ? "^" : "*");
			}
			System.out.println();
		}
		
		//for(int i = 0; i < 5; i++) {
			//for(int j = 0; j < 4-i; j++) {
			//	System.out.print("^");
			//}
			//for(int j = 0; j<i+1; j++) { 
			//System.out.print("*");
			//}
			//System.out.println();
		//}
		
	}
	public static void main06(String[] args) {
		// *****   i  = 0  j  =0
		// ^****   i  = 1  j = 1
		// ^^***   i  = 2  j = 2
		// ^^^**   i  = 3  j = 3
		// ^^^^*
		//for(int i = 0; i < 5; i++) {
		//	for(int j = 0; j < i+1; j++) {
			//	System.out.print("^");
		//	}
		//	for(int j = 0; j < 4-i; j++) {
		//		System.out.print("*");
		//	}
		//	System.out.println();
		
		for(int i =0; i<5; i++) {
			for(int j =0; j<5; j++) {
				System.out.print(j < i ? "^" : "*");
			}
			System.out.println();
		}
	}	
	public static void main07(String[] args) {
				// ^^^^*   0 : 4
				// ^^^**   1 : 3
				// ^^***   2 : 2
				// ^****   3 : 1
				// *****   4 : 0
				// ^****   5 : 1    
				// ^^***   6 : 2    
				// ^^^**   7 : 3    
				// ^^^^*   8 : 4
		int end = 4; //제동을 end 로 걸음 
 			for(int i=0; i<9; i++) {
 				for(int j =0; j <5; j++) {
 					System.out.print(j < end ? " " : "*");
 				}
 				System.out.println();
 				end = i < 4 ? end - 1 : end + 1;
 			}
	}
	public static void main08(String[] args) { //08
		// 별출력 프로그램    
		//  - 별 또는 공백이 반복한번에 한개씩 출력
		//
		//          *       1
		//         ***      3
		//        *****     5
		//       *******    7
		//      *********   9
		for(int i=0; i<5; i++) {
			for(int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for(int k=1; k<=i*2+1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main09(String[] args) {//09
		//      *********
		//       *******
		//        *****
		//         ***
		//          *
		for(int i =0; i <5; i++) {
			for(int j =1; j<=i; j++) {
				 System.out.print(" ");
			}
			for(int k =9; k>=i*2+1;k--) {
				 System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main10(String[] args) { //10
			//      *       1
		//         ***      3
		//        *****     5
		//       *******    7
		//      *********
		//       *******
		//        *****
		//         ***
		//          *
		for(int i=0; i<5; i++) {
			for(int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for(int k=1; k<=i*2+1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i =0; i <4; i++) {
			for(int j =0; j<=i; j++) {
				 System.out.print(" ");
			}
			for(int k =7; k>=i*2+1;k--) {
				 System.out.print("*");
			}
			System.out.println();
		}
		
	}
	public static void main11(String[] args) { //11
		//      *********
		//       *******
		//        *****
		//         ***
		//          *
		//          *       1
		//         ***      3
		//        *****     5
		//       *******    7
		//      *********
		for(int i =0; i <5; i++) {
			for(int j =1; j<=i; j++) {
				 System.out.print(" ");
			}
			for(int k =9; k>=i*2+1;k--) {
				 System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<5; i++) {
			for(int j = 4; j > i; j--) {
				System.out.print(" ");
			}
			for(int k=1; k<=i*2+1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main12(String[] args) {
		//		*********
			//	**** ****
			//	***   ***
			//	**     **
			//	*       *
			//	**     **
			//	***   ***
			//	**** ****
			//	*********	
		int c = 5;
		int r = c;
		
		for(int i = 1; i <= c; i++) {
			for(int j = r-i; j > 0; j--) {
				System.out.print("^");
			}
			for(int k = 0; k < i; k++) {
				System.out.print("*");
			}
			for(int k = 0; k< i-1; k++) {
				System.out.print("*");
			}
			for(int j = (r - i); j>0; j--) {
				System.out.print("^");
			}
			System.out.println();
		}
		
		for(int i = 1; i <=c-1; i++) {
			for(int j =0; j < i; j++) {
				System.out.print("^");
			}
			for(int k =(r -i); k >1; k--) {
				System.out.print("*");
			}
			for(int k =i; k< r; k++) {
				System.out.print("*");
			}
			for(int j =0; j <i; j++) {
				System.out.print("^");
			}
			System.out.println();
		}
	
	}
	public static void main13(String[] args) {
		int i,j;
		int n = 4;
		for(i=-n;i<=n;i++) {
			for(j=-n;j<=n;j++) {
				if(i+j>=n || i+j<=-n || i-j>=n || i-j<=-n) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public static void main14(String[] args) { //14
		int i,j;
		int n = 4;
		for(i=-n;i<=n;i++) {
			for(j=-n;j<=n;j++) {
				if(Math.abs(i)+Math.abs(j)>=n) { // Math.abs(음수) -를 없앤 양수를 반환 
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main15(String[] args) { //15
		//          *       1
		//         ***      3
		//        *****     5
		//       *******    7
		//      *********   9
		for(int i =0; i<5;i++){
			//공백 출력 
			for(int j=0;j<4-i+i*2+1;j++) {
				System.out.print(j<4-i ? " " : "*");
			}
			System.out.println();
		}
	}
	
	public static void main16(String[] args) { //16
		//      *********
		//       *******
		//        *****
		//         ***
		//          *
		for(int i=0;i<5;i++) {
			for(int j=0; j<i;j++) {//공백 0 1 2 3 4 5 i가 증가하면 공백도 증가 
				System.out.print(" ");
			}
			for(int j=0;j<9-i*2;j++) {//별출력
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main17(String[] args) {
	for(int i=0;i<5;i++) {
		for(int j=0;j<9-i;j++) {
			System.out.print(j<i ?" " : "*");
		}
		System.out.println();
		}
	}
	public static void main18(String[] args) { //18

	    //      *       1
	//         ***      3
	//        *****     5
	//       *******    7
	//      *********
	//       *******
	//        *****
	//         ***
	//          *
		//별개수만큼 
		int end = 1;
		for(int i =0;i<9;i++) {
			for(int j=0;j<5-end;j++) {
			System.out.print(" ");
			}
			for(int j=0;j<end*2-1;j++) {
				System.out.print("*");
			}
			System.out.println();
			end = i <4 ? end+1 :end-1;
		}
	}
	//반대로 
	public static void main19(String[] args) { //19
		int end = 4;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9-end;j++) {
				System.out.print(j<end ? " " :"*" );
			}
			System.out.println();
			
			end = i<4 ? end-1 : end+1;
		}
	}
	public static void main20(String[] args) { //20
		//      *********
		//       *******
		//        *****
		//         ***
		//          *
		//          *       1
		//         ***      3
		//        *****     5
		//       *******    7
		//      *********
	}
	public static void main21(String[] args) {
//		*********
			//	**** ****
			//	***   ***
			//	**     **
			//	*       *
			//	**     **
			//	***   ***
			//	**** ****
			//	*********
		
			int end = 5;
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					//System.out.print(j<end || j>8-end?"*":" ");
					System.out.print(j>=end && j<9-end?" " : "*");
				}
				System.out.println();
				end =i<4 ?end-1:end+1;
			}
	}
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int size = 0;
		while (true) {
			try {
				System.out.print("크기입력(홀수만)>>>");
				size = sc.nextInt();
				break;
			} catch (Exception e) {
				System.out.print("숫자만 입력하세요!");
				sc.next();
				continue;
			}
		}
		// 유효성 검사 : 5이상  15이하 값만 허용, 홀수만 입력 받을것.
		
		while(size%2==0 && (size < 5 || size > 15)) {
			
			try {
				if((size < 5 || size > 15)){
				System.out.println("5이상  15이하 값만 입력 하세요 !"); 
				System.out.print("크기입력(홀수만)>>>");
				size = sc.nextInt(); 
				continue;
				}
					System.out.println("홀수만 입력 하세요 !");
					System.out.print("크기입력(홀수만)>>>");
					size = sc.nextInt(); //int만 가지고온다 정수만가져간다.
			} catch (Exception e) {
				System.out.print("숫자만 입력하세요!");
				sc.next(); // 52k\n 엔터가 남아있기때문에 버퍼를 비워줘야한다. 
				size = 0;
				continue;
			} 
		}
		//완충역활을해주는 버퍼가 필요하다 

		int end = size/2 + 1;
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(j>=end && j<size-end? " " : "*");
			}
			System.out.println();
			end = i<size/2 ? end-1:end+1;
		}
	}
}

//mian09(null);
