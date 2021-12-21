package day12;

import java.io.IOException;
import java.util.Scanner;

public class Day12Ex02 {

	static Scanner scan = new Scanner(System.in);
	
	static int getNum() {
		int num = 0;
		int ch = 0;     // 파라미터 
		try {
			while((ch = System.in.read()) != '\n' ) {
				if(ch >= '0' && ch <= '9') {
					num = num * 10 + ch -'0';
				}
			}
		} catch(IOException e) { }
		return num;
	}
	
	public static int compare(int a,int b) {
		if(a == b) {
			return 0; // 값이 0이면 같다
		} else if(a < b) {
			return 1;  // a가 b보다 크면 1
		} else {
			return -1; 
		}
	}
	
	static void status(int cnt) {
		// 맟추고 나온건가? cnt가 다되어서 나온간?
				//cnt 0이 아니면 맞추고 나온것 0이면 그냥 실격!
				if(cnt == 0) {
					 System.out.println("기회를 모두 소진 했다. 실격!");
				} else {
					System.out.println("빙고!");
				}
	}
				
		static int getUserNum(int min, int max) {
			System.out.printf("사용자 입력(%d~%d사이) >>", min, max);
			int userNum = getNum();
			while(userNum<min || userNum>max) {
				System.out.println("입력 범위를 벗어 났습니다!");
				System.out.printf("다시 입력(%d~%d사이) >>", min, max);
				userNum = getNum();
					}
					return userNum;
				}
		
	public static void game() {
		// 컴퓨터가 1 ~ 100사이의 랜덤한 숫자(난수) 선택
		// 사용자가 5회 안에 맞추기 
		int min = 1, max = 100; //범위
		int cnt = 5; 
		int sysNum = (int)(min + Math.random() * max); //1보다 작은 변수가 발생 
		System.out.println("시스템이 난수를 선택 했습니다.("+sysNum+")");
		
		while(cnt > 0) { //cnt 가 0보다 크면 시도
			//사용자가 입력 받아서 비교하기
			System.out.println("남은 시도 횟수 : " + cnt);
			int userNum = getUserNum(min, max);
			int result = compare(sysNum, userNum); //비교
			if(result == 0) {
				break;
			}
			if(result == 1) {
				// 너무 큰숫자 -> max의 범위 변경
				System.out.println("너무 큰 숫자입니다!");
				max = userNum - 1;
			} else  {
				System.out.println("너무 작은 숫자입니다!");
				min = userNum + 1;
			}
			cnt--;
		} // end of while
		status(cnt);
	}   
	
	public static void main(String[] args) {
		// 높다 낮다 게임(카드 맞추기)
		// 컴퓨터가 1 ~ 100사이의 랜덤한 숫자(난수) 선택
		// 사용자가 5회 안에 맞추기 
		// 재시도 가능하게 구현
		// --- 입력 된 숫자가 맞나? 틀리나? 판별  if - esle 문으로 구현가능 
		// --- 맞으면 빙고, 틀리면 작다 / 크다를 출력
		while(true) {
			System.out.println("--- 게임 시작 ---");
			game();
			System.out.print("계속 하시겠습니까?(y/n) >> ");
			char isLoop = scan.next().charAt(0);
			while(!(isLoop == 'n' || isLoop == 'y')) {
				System.out.println("y또는 n만 입력하세요!");
				System.out.print("계속 하시겠습니까?(y/n) >> ");
				isLoop = scan.next().charAt(0);
			}
			if(isLoop == 'n') {
				break;
			}
		}
		System.out.println("수고했습니다!");
	}
}
