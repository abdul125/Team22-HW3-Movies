package model;

import java.util.List;

public class User {

	private int id=0;
	private String address= "";
	private String city= "";
	private String state= "";
	private String postalCode= "";
	private String email= "";
	private String phoneNumber= "";
	private String birthday= "";
	private int type=0;
	private int status=0;
	private int numOfVisits=0;
	private String firstName= "";
	private String lastName= "";
	private String userName;
	private String password;
	
	
	private List<Transactions> transactions;
	
	/* for the login*/
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	public User(int id, String userName, String password, String firstName, String lastName, String address, String city,
			String state, String postalCode, String email, String phoneNumber, String birthday, int type, int status,
			int numOfVisits) {
		super();

		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.type = type;
		this.status = status;
		this.numOfVisits = numOfVisits;
	}
	
	
	public User(String userName, String password, String firstName, String lastName, String address, String city,
			String state, String postalCode, String email, String phoneNumber, String birthday) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	
	public User(int id, String userName, String password, String firstName, String lastName, String address, String city,
			String state, String postalCode, String email, String phoneNumber, String birthday, int type, int status,
			int numOfVisits, List<Transactions> transactions) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
		this.type = type;
		this.status = status;
		this.numOfVisits = numOfVisits;
		this.transactions = transactions;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getNumOfVisits() {
		return numOfVisits;
	}


	public void setNumOfVisits(int numOfVisits) {
		this.numOfVisits = numOfVisits;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Transactions> getCreditCards() {
		return transactions;
	}

 		public void setCreditCards(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	
}
