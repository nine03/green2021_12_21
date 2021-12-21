package day13;

import java.util.Scanner;

public class Ch03Ex03 {
	static Scanner scan = new Scanner(System.in);

	public static void main00(String[] args) {
		// break label
		
		//실행하면 10 * 10 = 100번 
	aaa : for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				if(j % 3 == 0 ) break aaa; // 3의 배수 20번 break레이블을 쓰면 1번 break continue 똑같다
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
		
	}
	
	//break continue 응용
	public static void main(String[] args) { 
		int age = 0;
		
		while(true) {
			try {
				System.out.print("나이 입력: ");
				age = scan.nextInt();
				break;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace(); 
				System.out.print("입력 실패! 다시 ");
				scan.next(); // scan의 버퍼에서 \n을 제거한다.
				continue;
			}
		}
		
		if(age < 20) {
			System.out.println("미성년자에게는 술을 팔지 않습니다.");
		} else {
			System.out.println("맛있게 드세요!");
		}
	}

}
