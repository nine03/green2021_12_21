package etc;
// 3번 문제 main
import etc.Calc;

public class MainApp {
	public static void main(String[] args) {
		Calc c = new Calc(10,20);
		System.out.println(c.sum());
	}
}