package day12;

import static java.lang.System.out;

public class Day12Ex03 {

	public static void main00(String[] args) {
		// 1+2+3+4+5+6+7+8+9+10 = 55
		// while������ �����ϱ� 
		final int MAX = 10;
		
		// �����ϴ� ������ 0���� �ʱ�ȭ
		int sum = 0; // 1���� 10���� ����
		int num = 1; // 1���� 10���� �ϳ��� ���� �뵵

		while(num <= 10) {
			sum += num;
			System.out.print(num);
			System.out.print(num != MAX ? "+" : "=");  //���Կ����� ���࿡ ?  �ƴϸ� + ������ =
			num++;
			
		}
		System.out.println(sum);
	}
	// ������ ���� ��°��� ǥ���̰� 
	// ���鼭 ��°��� �����̴�.
	public static void main01(String[] args) {
		// 1+2-3+4-5+6-7+8-9+10=7
		final int MAX = 10; //����� ������⶧���� ���
		// �����ϴ� ������ 0���� �ʱ�ȭ
		final int MIN = 1;
		int sum = 0; // 1���� 10���� ����
		int num = MIN; // 1���� 10���� �ϳ��� ���� �뵵
		
		//���� ���� 
		// 1. 1~10���� ��� (num�� �����ϸ鼭 ����Ѵ�.)
		// 2. ����
		// if�� ���
		// ���� �ݺ��� 
		// ���ܸ� �ָ�ȴ�  ���ϱ� 
		
 		while(num <= MAX) {
 			out.print(num);
 			if(num % 2 == 1) {  //¦��  0�� �ƴҋ� Ȥ��  �������� 1�̸� Ȧ�� 
 				//sum = num == 1 ? sum + num : sum - num;
 				//sum = num == 1 ? num : sum - num;
 				sum = num == MIN  ? num : sum - num;
 				out.print("+"); // ����
 			}else {
 				sum += num;
 				out.print(num == MAX ? "=" : "-"); // ���� 
 			}
 			num = num + 1;
		}
 		out.println(sum);
	}
	
	public static void main02(String[] args) {
		final int MAX = 21;
		// �Ǻ���ġ ���� ����
		// 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 = 54
		// �տ� �ΰ����� ���ؼ� �״����׿� 
		// ������ 3�� �̻� �ʿ��ϴ� 
		
		int prev = 0;  // ������
		int curr = 1;  // ������ 
		int next = 0; // ������ 
		int sum = 0;//���� 
		
		while(curr <= MAX) { //������ ������ ����� ���̿����� �ݺ��Ѵ� �۴� �̸� �۰ų� ���� 
			//�����ϱ� 
			sum += curr;
			System.out.print(curr);
			System.out.print(curr == MAX ? "=" : "+" );  // ���� ó���� ���������� ���Ѵ�� ����.
			
			//ġȯ�ؼ� �����ϱ� 
			// 1. �������� ������ + ������  next = perv + curr;
				next = prev + curr;
			// 2. �������� ���������� ġȯ    prev = curr
				prev = curr; // ġȯ ���� �ٲٴ�
			// 3. �������� ���������� ġȯ(���ο� ������)
				curr = next;
		}
		out.println(sum);
	}
	public static void main03(String[] args) {
		final int MAX = 21;
		// �Ǻ���ġ ���� ����
		// 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21 = 54
		// �տ� �ΰ����� ���ؼ� �״����׿� 
		// ������ 3�� �̻� �ʿ��ϴ� 
		
		//int prev = 0;  // ������
		//int curr = 1;  // ������ 
		//int next = 0; // ������ 
		int sum = 0;//���� 
		
		//for������ �������غ���
		for(int p = 0,curr = 1,n = 0 ;curr <= MAX;n=p+curr,p=curr,curr=n) {
		 // while(curr <= MAX) { //������ ������ ����� ���̿����� �ݺ��Ѵ� �۴� �̸� �۰ų� ���� 
			//�����ϱ� 
			sum += curr;
			System.out.print(curr);
			System.out.print(curr == MAX ? "=" : "+" );  // ���� ó���� ���������� ���Ѵ�� ����.
		}
			//ġȯ�ؼ� �����ϱ� 
			// 1. �������� ������ + ������  next = perv + curr;
			//	next = prev + curr;
			// 2. �������� ���������� ġȯ    prev = curr
			//	prev = curr; // ġȯ ���� �ٲٴ�
			// 3. �������� ���������� ġȯ(���ο� ������)
				//curr = next;
		out.println(sum);
		}
	public static void main04(String[] args) {
		final int MAX = 21;
		// �Ǻ���ġ ���� ����
		// 1 + 1 - 2 + 3 - 5 + 8 - 13 + 21 = 14
		int prev = 0; // ������
		int curr = 1; // ������
		int next = 0; // ������
		int sum = 0; //���� 
		
		for(int i = 1; curr <= MAX; i++) {
			out.print(curr);
			if(i % 2 == 1) {
				sum = curr == 1  ?  curr : sum - curr;
					out.print("+"); //���� 
			} else {
				sum += curr;
					out.print(curr == MAX ? "=" : "+" ); // ����
			}
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		out.println(sum);
	}
	public static void main05(String[] args) {
		final int MAX = 21;
		// �Ǻ���ġ ���� ����
		// 1 + 1 - 2 + 3 - 5 + 8 - 13 + 21 = 14
		int prev = 0; // ������
		int curr = 1; // ������
		int next = 0; // ������
		int sum = 0; //���� 
		
		int i = 1;
		while(curr <= MAX) { //���̸� 
			System.out.print(curr);
			//System.out.printf("(%s)",i % 2 ==1 "+" : "-");  //��ȣ���ִºκ��� ��ȣ  Ȧ���� + ¦���� -
			// i % 2 != 0 
			// i % 2 ==1 "+" : "-"
			
			if(i % 2 ==1) {
				sum = i == 1 ? curr : sum - curr;
				System.out.print("+");
			}else {
				sum += curr;
				System.out.print(curr == MAX ?  "=": "-"); 
			}
				
			//ġȯ�����ֱ� 
			next = prev + curr;
			prev = curr;
			curr = next;
 			
			i = i + 1;
			
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		final int MAX = 21;
		// �Ǻ���ġ ���� ����
		// 1 + 1 - 2 + 3 - 5 + 8 - 13 + 21 = 14
		int prev = 0; // ������
		int curr = 1; // ������
		int next = 0; // ������
		int sum = 0; //���� 
		
		// ������
		// ���� �������� ������ ���Ѵ�.
		// ���� �������� ������ ���·Ӵ� - ����
		
		// �����϶�. ������ �� ���δ�.
		// �ܿ�⸸ �� ���ΰ� ���� ���ϰ� �Ѵ�. - ������(�ڻ�)
		
		//�ѹ��� �÷��� �ѹ��� ���̳ʽ�  
		//flag�˰���
		//true ���ϰ� false ���� 
		boolean flag = true;
		while(curr <= 21) {
			System.out.print(curr);
			
			if(flag) {
				sum = curr == 1 ? curr : sum - curr;
				System.out.print("+"); // �����ѹ� ����ְ� ���� 
				flag = false;
			}else {
				//System.out.print("-"); // �����ѹ� ����ְ� ����
				sum += curr;
				System.out.print(curr == MAX ?  "=": "-"); 
				flag = true;
			}
			
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		System.out.println(sum);
	}
}

