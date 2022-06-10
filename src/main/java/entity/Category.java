package entity;

public class Category {
	private int cateID;
	private String cateName;
	private boolean status;

	public Category(int cateID, String cateName, boolean status) {
		super();
		this.cateID = cateID;
		this.cateName = cateName;
		this.status = status;
	}
	public Category(String cateName, boolean status) {
		super();
		this.cateName = cateName;
		this.status = status;
	}
	public Category() {
		super();
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Category [cateID=" + cateID + ", cateName=" + cateName + ", status=" + status + "]";
	}
	
}
