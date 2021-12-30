package ch05.ex09;

import java.util.Scanner;

interface Stack {
	int length();
	int capacity();
	String pop();
	boolean push(String val);
}

public class StringStack implements Stack {

	private String[]  stack;  // 참조변수 배열  외부에서 접근못하도록 캡슐화
	private int top;
	
	
	public StringStack(int capacity) {
		stack = new String[capacity];
		top = 0;
	}
	
	  public int length() {
	      return top;
	   }

	   public int capacity() {
	      return stack.length;
	   }

	   public String pop() {
		   if(top-1 < 0) {
			   return null;
		   }		  
	      return stack[--top];
	   }

	   public boolean push(String val) {
		   if(top >= capacity()) {
	     	return false;
		   }
		   stack[top++] = val;
		   return true;
	   }

	   public static void main(String[] args) {
		   Scanner scan = new Scanner(System.in);
		   System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		    int capacity = scan.nextInt();
		    StringStack stack = new StringStack(capacity);
		    while(true) {
		    	System.out.print("문자열 입력 >> ");
		    	String str = scan.next();
		    	if(!stack.push(str)) {
		    		System.out.println("스택이 꽉 차서 푸시 불가!");
		    		break;
		    		// "그만"을 만들고싶으면 equals 사용할것 
		    	}
		    }
		    scan.close();
		    System.out.print("스택에 저장된 모든 문자열 팝 : ");
		    while(true) {
		    	String str = stack.pop();
		    	if(str == null) break;
		    	System.out.print(str + " ");
		    }
		    System.out.println();
	   }
	}
