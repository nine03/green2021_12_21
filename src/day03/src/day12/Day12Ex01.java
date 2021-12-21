package day12;

import java.io.IOException;

public class Day12Ex01 {

	static int getNum() {
		int num = 0;
		int ch = 0;     // �Ķ���� 
		try {
			while((ch = System.in.read()) != '\n' ) {
				if(ch >= '0' && ch <= '9') {
					num = num * 10 + ch -'0';
				}
			}
		} catch(IOException e) { }
		return num;
		
	}
	
	static int input(String s) {
		System.out.print(s);
		return getNum();
	}
	
	public static void main(String[] args) {
		// ���� 3���� �Է� �޾Ƽ� ū��, �߰�, �������� ����ϴ� ���α׷��� �����.
		int a,b,c;
		int  max = 0, mid,min=0;
		
		a = input("���� �Է� a>>> ");
		b = input("���� �Է� b>>> ");
		c = input("���� �Է� c>>> ");
		
		//System.out.printf("%d, %d, %d\n",a,b,c);
		
		// �ǻ��ڵ� (������ �˼� �ִ��ڵ�)
		//1. �ΰ� ���ڸ� ���ؼ� ū���� Max, �������� min�� �Է� 
		//2. ������ �Ѱ��� ���ڸ� max�� ���ؼ� max���� ũ�� maxġȯ
		//3. ���� max���� �۴ٸ� �װ��� min�� ���ؼ� min ���� �۴ٸ� min ġȯ
		//4. ������ ���ڰ� max���ٵ� ũ�� �ʰ� min���ٵ� �����ʴٸ� �װ��� mid
		
		if(a > b) {
			max = a;
			min = b;
		} else {
			max = b;
			min = a;
		} 
		
		if(c > max) {
			mid = max;   //����� ġȯ
			max = c;
		} else if(c < min) {
			mid = min;
			min = c;
		} else {
			mid = c; // ū�ŵ� �����ŵ� �ƴϴ� 
		} 
		
		System.out.printf("%d, %d, %d\n",max,mid,min);
	}

}
