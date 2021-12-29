package homework;

public class PayMentTest {
	public static void main(String[] args) throws PayException {
		CardPayment card1 = new CardPayment("스타벅스", "아메리카노", 4500, "5000-4784-5597-5416","0070",0);
		
		payProcess(card1);
		System.out.println("-------------------------------------");
		CashPayment cash1 = new CashPayment("이디아","카푸치노",5500,"010-1234-1234");
		payProcess(cash1);
		System.out.println("-------------------------------------");
	}
	public static void payProcess(Payment p) throws PayException {
		p.pay();
		System.out.println(p);
	}
}
