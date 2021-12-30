package ch05.ex03;

public class Won2Dollar extends Converter {
	
	private String srcString = "원";
	private String destString = "달러";
	
	//생성자
	
	public Won2Dollar(double ratio) {
		super.ratio = ratio; // 환율
	}
	
	@Override
	protected double convert(double src) {
		return src / ratio; // 달러를 원으로 /   원을 달러로 *
	}

	@Override
	protected String getSrcString() {
		// TODO Auto-generated method stub
		return srcString;
	}

	@Override
	protected String getDestString() {
		// TODO Auto-generated method stub
		return destString;
	}

	public static void main(String[] args) {
		Won2Dollar toDollar = new Won2Dollar(1200);
		toDollar.run();

	}

}
