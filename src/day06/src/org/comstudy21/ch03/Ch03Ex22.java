package org.comstudy21.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Ch03Ex22 {

	public static void main00(String[] args) {
		// 4����Ʈ ���� ���� ���� �� �ʱ�ȭ
		String[] names = {"��¡��","�öѱ�","�뱸","����","�ź���"};
		int[] price = {9000,3000,5000,6000,200000};
		
		for(int i =0; i < names.length; i++) {
			System.out.printf("%s�� ������ %d���Դϴ�.\n",names[i],price[i]);
		}
	}

	
	
	public static void test_rever(String[] args){
		int[] arr = {10,20,30,40,50,60,70,80,90,100};
		// Arrays�� �̿��ؼ� ������� ����ϱ�
		System.out.println(Arrays.toString(arr));
		//reverse(arr);  // �� ���� ���۷��� ���� ����  ��ġ�� ���� 
		// System.out.println(Arrays.toString(arr))
		
		// �ݺ����� �̿��ؼ�  arr�迭�� ��Ұ��� ��ġ�� reverse �Ѵ�. 
		// 0 -> 4, 4 -> 0 , 1 - > 3, 3 -> 1 
		// [50, 40, 30, 20, 10] �����ϵ��� temp
		//int temp;
		//for(int i = arr.length - 1; i >= 0; i --) {
		//	System.out.print(arr[i] + " ");
		//}
		// ġȯ ����
		
		
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
		
		// �������� �����ؼ� ����Ͻÿ�.
		// [1,2,3,4,5,6,7,8,9]
		// ���������������� ���� ���� 
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
			// �������� �����ؼ� ����Ͻÿ�. (��������)
			
			// �������� ,���� ������ �����ؼ� ������ ������.
				// [1,2,3,4,5,6,7,8,9]
			// ���� ���� 
		 //i,j �� �� �ݺ�������ϳ� ? �ݺ��ϳ������� ���ϱ� �������  
		// i�� 1���� j�� 2���� ����for���� �ʿ��� 
	//	for(int i = 0; i<arr.length - 1;i++) {// length-1 ������ �������� ���� 
		//	for(int j=i+1;i<arr.length;j++) { // i���� �Ѱ� �����ֱ� 
			//	if(arr[i] < arr[j]) {  // ��� ��    �޿� ������ ���� ����   �޿� ũ�� ���� ����
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
			// �ζ� ��ȣ�� �ߺ� ���� �������� �����Ͻÿ�.
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
		//��ȣ ����
		for(int i =0; i < 6; i++) {
			arr[i] = rand.nextInt(45)+1;
			// �ߺ� ��ȣ ����
			for(int j =0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		// ��ȣ ��� 
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
			for(int j =0; j < i; j++) { // �ߺ� ����
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		for(int i =0; i< arr.length; i++) {
			for(int j =0;j<i;j++) {
				if(arr[i] < arr[j]) { //��������
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
			// ���� ������ num�� ���� lotto �迭�� ����� ��Ҹ� ���Ѵ�.
			// --> num�� ���� ���� �̹� �ִٸ� �ٽ� num�� �����Ѵ�.
			// ���� �ٽ� ������ num�� lotto�� ��Ҹ� ���Ѵ�. (��� �ݺ�) ���������� 
			for(int j =0; j <i;j++) {
				if(num == lotto[j]) {
					 num = (int)(1+Math.random()*45);
					 j = -1;
				}
			}
			lotto[i] = num;
			
		}
		// �ζ� ��ȣ�� �ߺ� ���� �������� �����Ͻÿ�.
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
		final int MAX = 6;  // ��ġ�� ���ϴ� 
		int[] lotto = new int[MAX];
		// ���� ��ġ�� �����ϴ�.  1-45����
		int[] balls = new int[45];
		for(int i=1; i<=45; i++) {
			balls[i-1] = i;
		}
		// ������ ��ġ�� 
		// 45����
		//System.out.println(Arrays.toString(balls));
		System.out.println(" 1 ~ 45 ������ ���� �غ�Ǿ���.");
		// �ǻ��ڵ�
		// 1. balls �迭 index�� �����ϰ� �����Ѵ�.
		// 2. �� ������ index ��ġ�� ��ȣ�� 0�� �ƴϸ� lotto�迭�� �߰��Ѵ�.
		// 3. �̾ƿ� index ��ġ��  ��� ���� 0���� ����.
		// 4. index ��ġ�� ���� 0�̸� �ٸ� ������ index ����. (������ �ݺ�)
		// index�� �����ϰ� �ߴ�.
		for(int i=0;i<lotto.length;) {
			int index = (int)(Math.random() * 45); // 0 ~44������ ���� �߻� 
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
