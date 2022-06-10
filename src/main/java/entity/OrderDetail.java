package entity;

public class OrderDetail extends Orders{
	private int orderDetailID;
	private int orderID;
	private int productID;
	private int detailQuantity;
	private String detailProductName;
	private double detailPrice;
	private String size;
	private int VAT;
	private double subtotal;
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getOrderDetailID() {
		return orderDetailID;
	}
	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getDetailQuantity() {
		return detailQuantity;
	}
	public void setDetailQuantity(int detailQuantity) {
		this.detailQuantity = detailQuantity;
	}
	public String getDetailProductName() {
		return detailProductName;
	}
	public void setDetailProductName(String detailProductName) {
		this.detailProductName = detailProductName;
	}
	public double getDetailPrice() {
		return detailPrice;
	}
	public void setDetailPrice(double detailPrice) {
		this.detailPrice = detailPrice;
	}
	public int getVAT() {
		return VAT;
	}
	public void setVAT(int vAT) {
		VAT = vAT;
	}
	public OrderDetail(int orderDetailID, int orderID, int productID, int detailQuantity, String detailProductName,
			double detailPrice, int vAT) {
		super();
		this.orderDetailID = orderDetailID;
		this.orderID = orderID;
		this.productID = productID;
		this.detailQuantity = detailQuantity;
		this.detailProductName = detailProductName;
		this.detailPrice = detailPrice;
		VAT = vAT;
	}
	public OrderDetail() {
		super();
	}
	@Override
	public String toString() {
		return "OrderDetail [orderDetailID=" + orderDetailID + ", orderID=" + orderID + ", productID=" + productID
				+ ", detailQuantity=" + detailQuantity + ", detailProductName=" + detailProductName + ", detailPrice="
				+ detailPrice + ", size=" + size + ", VAT=" + VAT + ", subtotal=" + subtotal + "]";
	}
	
	
}
