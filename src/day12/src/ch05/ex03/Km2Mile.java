package ch05.ex03;

public class Km2Mile extends Converter {
	
	private String srcString = "Km";
	private String destString = "Mile";
	
	//생성자
	
	public Km2Mile(double ratio) {
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
		Km2Mile toMile = new Km2Mile(1.6);
		toMile.run();

	}

}
