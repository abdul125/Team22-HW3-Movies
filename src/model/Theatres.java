package model;

public class Theatres {
	private int id;
	private String name;
	private String Address;
	private int ownerId;
	private String city;
	private String state;
	private String postalCode;
	
	
	public Theatres(int id, String name, String address, int ownerId, String city, String state, String postalCode) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
		this.ownerId = ownerId;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
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
	
	
}
