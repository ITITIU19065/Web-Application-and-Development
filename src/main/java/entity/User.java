package entity;

public class User {
	private String userName;
	private String userPass;
	private String userID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPass=" + userPass + "]";
	}
	public User(String userName, String userPass) {
		super();
		this.userName = userName;
		this.userPass = userPass;
	}
	public User() {
		super();
	}
	
}
