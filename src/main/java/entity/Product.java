package entity;

public class Product {
	private int productID;
	private int cateID;
	private int brandID;
	private String brandName;
	private String categoryName;
	private String productName;
	private boolean status;
	private String image;
	private double price;
	private int discount;
	private String desciption;
	private int quantity;
	private double disPrice;
	public Product(int productID, int cateID, int brandID, String productName, boolean status, String image,
			double price, int discount, String desciption, int quantity, double disPrice) {
		super();
		this.productID = productID;
		this.cateID = cateID;
		this.brandID = brandID;
		this.productName = productName;
		this.status = status;
		this.image = image;
		this.price = price;
		this.discount = discount;
		this.desciption = desciption;
		this.quantity = quantity;
		this.disPrice = disPrice;
	}
	public double getDisPrice() {
		return disPrice;
	}
	public void setDisPrice(double disPrice) {
		this.disPrice = disPrice;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public int getBrandID() {
		return brandID;
	}
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", cateID=" + cateID + ", brandID=" + brandID + ", productName="
				+ productName + ", status=" + status + ", image=" + image + ", price=" + price + ", discount="
				+ discount + ", desciption=" + desciption + ", quantity=" + quantity + ", disPrice=" + disPrice + "]";
	}
	
}
