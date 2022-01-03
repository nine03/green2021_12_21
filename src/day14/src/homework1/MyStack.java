package homework1;

import java.util.ArrayList;
// 9번 문제
public class MyStack<T> implements IStack<T> {
	ArrayList<T> l = null;
	public MyStack() {
		l = new ArrayList<T>();
	}

	@Override
	public T pop() {
		if (l.size() == 0)
			return null; 
		else {
			return l.remove(0); 
		}
	}

	@Override
	public boolean push(T ob) {
		l.add(0, ob); 
		return true;
	}
}