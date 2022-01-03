package homework1;
// 9번 문제
public class StackManager {
	public static void main (String[] args) {
		IStack<Integer> stack = new MyStack<Integer>();
		for (int i=0; i<10; i++) stack.push(i); 
		while (true) { 
			Integer n = stack.pop();
			if(n == null) break; 
			System.out.print(n + " ");
		}
	}
}
