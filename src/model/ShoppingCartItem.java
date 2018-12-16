package model;

import java.io.Serializable;

public class ShoppingCartItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int movieID;
	private int ticketQuantity;
	private String movieName;
	private String theatreName;
	private String showTime;
	private int showingId;
	private int price;
		
	public ShoppingCartItem(int movieID, int ticketQuantity, String movieName, String theatreName,
			String showTime, int showingID, int price) {
		super();
		this.movieID = movieID;
		this.ticketQuantity = ticketQuantity;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.showTime = showTime;
		this.showingId = showingID;
		this.price = price;
	}
	
	public int getMovieID() {
		return this.movieID;
	}
	public int getShowingId() {
		return this.showingId;
	}

	public void setShowingId(int showingId) {
		this.showingId = showingId;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public int getTicketQuantity() {
		return this.ticketQuantity;
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
		return this.theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getShowTime() {
		return this.showTime;
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
	
	
}
