package org.comstudy21.exam1;

import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.out;

public class Day11Ex01 {
	//public static Scanner scan = new Scanner(System.in); 스캐너는 걸러주지 못한다.
	public static int getNum() {
		int num = 0; // 정보가 제대로 들어오지 않았다. 누적일때는 
		int ch = 0;
		try {
			while((ch = System.in.read()) != '\n') {
			 if(ch >= '0' && ch <= '9') {
			 num = num * 10 + ch - '0';  // 0  48이 아스키코드 0이다 숫자를 넣으면 문자가 숫자로 바꿔서 저장됨  
			 
			 }
			}
		} catch (IOException e) {}
		return num;
	}
	
	public static void main(String[] args) {
		// 정수 3개를 입력 받아서 큰수, 중간, 작은수를 판별하는 프로그램.
		int a, b, c; // 지역변수는 초기화가 필요하다
		int max = 0, mid = 0, min = 0;
		
		out.print("정수1 입력 >>> ");
		a = getNum(); // 엔터를 쳐야됨 뛰어쓰기 안됨 
		out.print("정수2 입력 >>> ");
		b = getNum();
		out.print("정수3 입력 >>> ");
		c = getNum();
		
		out.printf("%d, %d, %d\n",a, b, c);
		//-35가 나오는 이유는 엔터에서 친값을 뺀거
		
		//논리연산 ,반복문 쓰지말고 if문 연습 
		if(a>b) {
			if(a>c) {
				max = a;
				if(b<c) {
					mid = c; min = b;
				}else {
					mid = b; min = c;
				}
			}else {
				max = c;
				if(a<b) {
					mid = b; min = a;
				}else {
					mid = a; min = b;
				}
			}
		}else {
			if(b>c) {
				max = b;
				if(a<c) {
					mid = c; min = a;
				}else {
					mid = a; min = c;
				}
			} else {
				max = c;
				if(a<b) {
					mid = b; min = a;
				}else {
					mid = a; min = b;
				}
			}
		}

		
		out.println("제일 큰수는 " + max); 
		out.println("제일 작은수는 " + min);
		out.println("중간 수는 " + mid);
	}

}
