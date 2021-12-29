package homework;

abstract public class Payment implements Payable {
	protected String shopName;
	protected String productName;
	protected long productPrice;
	
	public Payment() {
		
	}
	public Payment(String shopName, String productName, long productPrice) {
		super();
		this.shopName = shopName;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public abstract void pay() throws PayException;
	
	public String getShopName() {
		return shopName;
	}
	
	public void setShopeName(String shopeName) {
		this.shopName = shopName;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public long getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
}
