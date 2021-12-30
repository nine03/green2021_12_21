package ch05.ex03;

import java.util.Scanner;

public abstract class Converter {
	protected abstract double convert(double src);
	protected abstract String getSrcString();
	protected abstract String getDestString();
	protected double ratio;
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("%s을 %s로 바꿉니다.\n",getSrcString(),getDestString());
		System.out.printf("%s을 입력하세요>>",getSrcString());
		double val = scan.nextDouble();
		double res = convert(val);
		System.out.printf("변환 결과: %.2f%s입니다\n",res,getDestString()); //%.2f는 소수점 둘째자리 
		scan.close();
	}
}
