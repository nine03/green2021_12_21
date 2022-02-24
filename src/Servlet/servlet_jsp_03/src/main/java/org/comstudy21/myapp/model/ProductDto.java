package org.comstudy21.myapp.model;

public class ProductDto {
	private static int sequence = 1;
	private int no;
	private String pName;
	private int price;
	private int ea;
	
	public static int nextSeq() {
		return sequence++;
	}
	
	public ProductDto() {
		this(0, "", 0, 0);
	}

	public ProductDto(int no, String pName, int price, int ea) {
		this.no = no;
		this.pName = pName;
		this.price = price;
		this.ea = ea;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	@Override
	public String toString() {
		return "ProductDto [no=" + no + ", pName=" + pName + ", price=" + price + ", ea=" + ea + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDto other = (ProductDto) obj;
		if (no != other.no)
			return false;
		return true;
	}

}
