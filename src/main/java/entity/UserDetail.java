package entity;

public class UserDetail {
	private String userID;
	private String firstName;
	private String lastName;
	private String phone;
	private int age;
	private String gender;
	private String address;
	private String city;
	private int questionID;
	private String answer;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public UserDetail() {
		super();
	}
	public UserDetail(String firstName, String lastName, String phone, int age, String gender, String address,
			String city, int questionID, String answer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.questionID = questionID;
		this.answer = answer;
	}
	public UserDetail(int questionID, String answer) {
		super();
		this.questionID = questionID;
		this.answer = answer;
	}
	public UserDetail(String firstName, String lastName, String phone, int age, String gender, String address,
			String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.city = city;
	}
	
}
