package entity;

public class WishList {
	private int WishId;
	private int productId;
	private int userId;
	public int getWishId() {
		return WishId;
	}
	public void setWishId(int wishId) {
		WishId = wishId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public WishList(int wishId, int productId, int userId) {
		super();
		WishId = wishId;
		this.productId = productId;
		this.userId = userId;
	}
	public WishList() {
		super();
	}
	@Override
	public String toString() {
		return "WishList [WishId=" + WishId + ", productId=" + productId + ", userId=" + userId + "]";
	}
	
}
