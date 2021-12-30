package ch05.ex01;

public class IPTV extends ColorTV{
	private String ip;
	public IPTV(String ip, int size, int color) {
		super(size,color);
		this.ip = ip;
	}
	@Override
	public void printProperty() {
		System.out.printf("나의 IPTV는 %s 주소의 ",ip);
		super.printProperty();
	}

	public static void main(String[] args) {
		IPTV iptv = new IPTV("192.168.1.2",32,2048);
		iptv.printProperty();

	}

}
