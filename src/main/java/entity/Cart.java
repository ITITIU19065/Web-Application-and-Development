package entity;

public class Cart extends Product{
	private int quantityOrder;
	private double subTotal;
	private String userName;
	private String size;
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public int getQuantityOrder() {
		return quantityOrder;
	}

	public void setQuantityOrder(int quantityOrder) {
		this.quantityOrder = quantityOrder;
	}

	public Cart(int quantity) {
		super();
		this.quantityOrder = quantity;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [quantityOrder=" + quantityOrder + "]";
	}

	public Cart(int productID, int cateID, int brandID, String productName, boolean status, String image, double price,
			int discount, String desciption, int quantity, double disPrice, int quantityOrder) {
		super(productID, cateID, brandID, productName, status, image, price, discount, desciption, quantity, disPrice);
		this.quantityOrder = quantityOrder;
	}
	
}
