package org.comstudy21.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Ch03Ex22 {

	public static void main00(String[] args) {
		// 4바이트 참조 변수 생성 및 초기화
		String[] names = {"오징어","꼴뚜기","대구","명태","거북이"};
		int[] price = {9000,3000,5000,6000,200000};
		
		for(int i =0; i < names.length; i++) {
			System.out.printf("%s의 가격은 %d원입니다.\n",names[i],price[i]);
		}
	}

	
	
	public static void test_rever(String[] args){
		int[] arr = {10,20,30,40,50,60,70,80,90,100};
		// Arrays를 이용해서 순서대로 출력하기
		System.out.println(Arrays.toString(arr));
		//reverse(arr);  // 콜 바이 레퍼런스 참고가 같다  위치만 같다 
		// System.out.println(Arrays.toString(arr))
		
		// 반복문을 이용해서  arr배열의 요소값을 의치를 reverse 한다. 
		// 0 -> 4, 4 -> 0 , 1 - > 3, 3 -> 1 
		// [50, 40, 30, 20, 10] 스왑하듯이 temp
		//int temp;
		//for(int i = arr.length - 1; i >= 0; i --) {
		//	System.out.print(arr[i] + " ");
		//}
		// 치환 스왑
		
		
		// public static void reverse(int[] arr){
				//}
		for(int i=0,end= arr.length-1;i<arr.length/2;i++) {
			int temp = arr[i];
			 arr[i] = arr[end-i];
			 arr[end-i] = temp;
		}
		 System.out.println(Arrays.toString(arr));
	}
	
	public static void main01(String[] args) {
		//int[] arr = {7,3,2,8,1,6,9,4,5};
		
		// 오름차순 정렬해서 출력하시오.
		// [1,2,3,4,5,6,7,8,9]
		// 선택정렬하지말고 버블 정렬 
		//for(int i = 0; i < arr.length - 1; i++) {
			//for(int j=i+1; j<arr.length; j++) {
				// if(arr[i]>arr[j]) {
		          //      int temp = arr[j];
		            //    arr[j] = arr[i];
		              //  arr[i] = temp;
		            //}
			//}
			
		//}
		  //System.out.println(Arrays.toString(arr));
	}
	//	public static void main(String[] args) {
		//	int[] arr = {7,3,2,8,1,6,9,4,5};
			// 오름차순 정렬해서 출력하시오. (선택정렬)
			
			// 삽입정령 ,버블 정렬을 공부해서 구현해 보세요.
				// [1,2,3,4,5,6,7,8,9]
			// 선택 정렬 
		 //i,j 를 왜 반복해줘야하나 ? 반복하나가지고 비교하기 어려워서  
		// i가 1번지 j가 2번지 이중for문이 필요함 
	//	for(int i = 0; i<arr.length - 1;i++) {// length-1 끝에서 마지막꺼 뺀거 
		//	for(int j=i+1;i<arr.length;j++) { // i보다 한개 더해주기 
			//	if(arr[i] < arr[j]) {  // 요소 비교    뒷에 작은게 오름 차순   뒷에 크면 내림 차순
				//	int temp = arr[i];
				//	arr[i] = arr[j];
				//	arr[j] = temp;
			//	}
		//	}
			
		//}
		//System.out.println(Arrays.toString(arr)); 
	//}
	
	public static void main02(String[] args) {
		final int SIZE = 6;
		int[] lotto = new int[SIZE];
		
		for(int i =0; i<SIZE; i++) {
			int num = (int)(1+Math.random()*45);
			lotto[i] = num;
			// 로또 번호가 중복 없이 나오도록 개선하시오.
			for(int j = 0; j < i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
		}
		for(int i =0;i < lotto.length;i++) {
		}
		System.out.println(Arrays.toString(lotto));
	}
	
	public static void main03(String[] args) {
		Random rand = new Random();
		int[] arr = new int[6];
		//번호 생성
		for(int i =0; i < 6; i++) {
			arr[i] = rand.nextInt(45)+1;
			// 중복 번호 제거
			for(int j =0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		// 번호 출력 
		for(int i = 0; i < 6; i++) {
		}
		System.out.print(Arrays.toString(arr));
	}
	
	public static void main04(String[] args) {
		Random rand = new Random();
		int[] arr = new int[6];
		int temp;
		for(int i=0; i< 6; i++) {
			arr[i] = rand.nextInt(45)+1;
			for(int j =0; j < i; j++) { // 중복 제거
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		for(int i =0; i< arr.length; i++) {
			for(int j =0;j<i;j++) {
				if(arr[i] < arr[j]) { //내림차순
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.print(Arrays.toString(arr));
	}
	public static void main05(String[] args) {
			HashSet<String> lottoSet = new HashSet<String>();
			ArrayList<String> arrList = new ArrayList<String>();
			
			while(lottoSet.size() < 7) {
				int num = (int)(Math.random() * 45);
				
				if(num != 0) {
					lottoSet.add(num + "");
				}
			}
			
			arrList.addAll(lottoSet);
			for(int i = 0; i < arrList.size(); i++) {
				if(i == 6) {
					System.out.print(arrList.get(i));
				}else {
					System.out.print(arrList.get(i)+",");
				}
			}
		}
	
	public static void main06(String[] args) {
		final int SIZE = 6;
		int[] lotto = new int[SIZE];
		
		for(int i =0; i<SIZE; i++) {
			int num = (int)(1+Math.random()*45);
			// 새로 생성한 num의 값과 lotto 배열에 저장된 요소를 비교한다.
			// --> num과 같은 값이 이미 있다면 다시 num을 생성한다.
			// 새로 다시 생성한 num과 lotto의 요소를 비교한다. (계속 반복) 끝날때까지 
			for(int j =0; j <i;j++) {
				if(num == lotto[j]) {
					 num = (int)(1+Math.random()*45);
					 j = -1;
				}
			}
			lotto[i] = num;
			
		}
		// 로또 번호가 중복 없이 나오도록 개선하시오.
		System.out.println(Arrays.toString(lotto));
	}
	public static void main07(String[] args) {
		final int SIZE = 6;
		int[] lotto = new int[SIZE];
		
		int cnt = 0;
		while(cnt < 6) {
			
			lotto[cnt] = (int)(Math.random()*6);
			boolean flag = true;
			for(int i = 0; i < cnt; i++) {
				if(lotto[cnt] == lotto[i]){
					flag = false;
					break;
				}
			}
			if(flag) cnt ++;
		}
		
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	}
	public static void main(String[] args) {
		final int MAX = 6;  // 고치지 못하는 
		int[] lotto = new int[MAX];
		// 공의 위치기 랜덤하다.  1-45까지
		int[] balls = new int[45];
		for(int i=1; i<=45; i++) {
			balls[i-1] = i;
		}
		// 랜던한 위치를 
		// 45번지
		//System.out.println(Arrays.toString(balls));
		System.out.println(" 1 ~ 45 까지의 공이 준비되었다.");
		// 의사코드
		// 1. balls 배열 index를 랜덤하게 선택한다.
		// 2. 그 선택한 index 위치의 번호가 0이 아니면 lotto배열에 추가한다.
		// 3. 뽑아온 index 위치의  요소 값을 0으로 변경.
		// 4. index 위치의 값이 0이면 다른 랜덤한 index 선택. (끝까지 반복)
		// index를 랜덤하게 했다.
		for(int i=0;i<lotto.length;) {
			int index = (int)(Math.random() * 45); // 0 ~44까지의 난수 발생 
			if(balls[index]!=0) {
			lotto[i] = balls[index];
			balls[index] = 0;
			i++;
			}
		}
		
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	}
}
