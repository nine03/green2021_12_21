package homework;

public class CashPayment extends Payment{
	private String cashReceiptNumber;

	public void pay() throws PayException {
		if(productPrice <= 0) {
			throw new PayException("가격이 잘못되었습니다.");
		}else {
			System.out.println("현금이 정상적으로 지불되었습니다.");
		}
	}
	public CashPayment() {
		
	}
	public CashPayment(String shopName, String productName, long productPrice,String cashReceiptNumber) {
		super(shopName,productName,productPrice); 
		this.cashReceiptNumber = cashReceiptNumber;
	}
	
	public String toString() {
		String msg = "현금 결제 정보";
		msg += "\n상점명 : "+shopName;
		msg += "\n상품명 : "+productName;
		msg += "\n상품가격 : "+productPrice;
		msg += "\n현금영수증번호 : "+cashReceiptNumber;
		return msg;
	}
	public String getCashReceiptNumber() {
		return cashReceiptNumber;
	}
	public void setCashReceiptNumber(String cashReceiptNumber) {
		this.cashReceiptNumber = cashReceiptNumber;
	}
}
