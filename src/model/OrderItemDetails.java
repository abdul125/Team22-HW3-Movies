package model;

public class OrderItemDetails {
	private int Id;
	private int movieID;
	private int ticketQuantity;
	private String movieName;
	private String theatreName;
	private String showTime;
	private int showingId;
	private int price;
	private int totalPrice;
	
	public OrderItemDetails(){
		
	}
		
	public OrderItemDetails(int Id,int movieID, int ticketQuantity, String movieName, String theatreName,
			String showTime, int showingID, int price, int totalPrice) {
		super();
		this.Id = Id;
		this.movieID = movieID;
		this.ticketQuantity = ticketQuantity;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.showTime = showTime;
		this.showingId = showingID;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	
	public int getMovieID() {
		return movieID;
	}
	public int getShowingId() {
		return showingId;
	}

	public void setShowingId(int showingId) {
		this.showingId = showingId;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public int getTicketQuantity() {
		return ticketQuantity;
	}
	public void setTicketQuantity(int ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public int getId() {
		return this.Id;
	}

	public void setId(int id) {
		this.Id = id;
	}
	
	public int gettotalPrice(){
		return this.totalPrice;
	}
	
	public void settotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}
}
