package entity;

public class Orders {
	private int orderID;
	private int userID;
	private boolean stateOrder;
	private String orderCreated;
	private boolean shippedStatus;
	private String shippedAddress;
	private String shippedCity;
	private String shippedDate;
	private String shippedNote;
	private String paymentType;
	private String shippedFname;
	private String shippedLName;
	private String shippedPhone;
	public String getShippedPhone() {
		return shippedPhone;
	}
	public void setShippedPhone(String shippedPhone) {
		this.shippedPhone = shippedPhone;
	}
	public String getShippedFname() {
		return shippedFname;
	}
	public void setShippedFname(String shippedFname) {
		this.shippedFname = shippedFname;
	}
	public String getShippedLName() {
		return shippedLName;
	}
	public void setShippedLName(String shippedLName) {
		this.shippedLName = shippedLName;
	}
	public String getShippedNote() {
		return shippedNote;
	}
	public void setShippedNote(String shippedNote) {
		this.shippedNote = shippedNote;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public boolean isStateOrder() {
		return stateOrder;
	}
	public void setStateOrder(boolean stateOrder) {
		this.stateOrder = stateOrder;
	}
	public String getOrderCreated() {
		return orderCreated;
	}
	public void setOrderCreated(String orderCreated) {
		this.orderCreated = orderCreated;
	}
	public boolean isShippedStatus() {
		return shippedStatus;
	}
	public void setShippedStatus(boolean shippedStatus) {
		this.shippedStatus = shippedStatus;
	}
	public String getShippedAddress() {
		return shippedAddress;
	}
	public void setShippedAddress(String shippedAddress) {
		this.shippedAddress = shippedAddress;
	}
	public String getShippedCity() {
		return shippedCity;
	}
	public void setShippedCity(String shippedCity) {
		this.shippedCity = shippedCity;
	}
	public String getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
	}
	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", userID=" + userID + ", stateOrder=" + stateOrder + ", orderCreated="
				+ orderCreated + ", shippedStatus=" + shippedStatus + ", shippedAddress=" + shippedAddress
				+ ", shippedCity=" + shippedCity + ", shippedDate=" + shippedDate + "]";
	}
	public Orders(int orderID, int userID, boolean stateOrder, String orderCreated, boolean shippedStatus,
			String shippedAddress, String shippedCity, String shippedDate) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.stateOrder = stateOrder;
		this.orderCreated = orderCreated;
		this.shippedStatus = shippedStatus;
		this.shippedAddress = shippedAddress;
		this.shippedCity = shippedCity;
		this.shippedDate = shippedDate;
	}
	public Orders() {
		super();
	}
	
}
