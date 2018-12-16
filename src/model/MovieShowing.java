package model;

import java.util.Date;
import java.io.Serializable;
/*
 * which one should we use? 
import java.sql.Date;
import java.util.Date; >> i chose this for now
*/
public class MovieShowing implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int Id;
	private int movieID;
	private String movieName;
	private String description;
	private String rating;
	private String posterThumbNail;
	private String theatreName;
	private int showRoomID;
	private String showTime;
	private int pricePerSeat;
	private int numberAvailableSeats;
		
	public MovieShowing(int id, int movieID, String movieName, String description, String rating, String posterThumbNail, String theatreName,
			int showRoomID, String showTime, int pricePerSeat, int numberAvailableSeats) {
		super();
		this.Id = id;
		this.movieID = movieID;
		this.movieName = movieName;
		this.description = description;
		this.rating = rating;
		this.posterThumbNail = posterThumbNail;
		this.theatreName = theatreName;
		this.showRoomID = showRoomID;
		this.showTime = showTime;
		this.pricePerSeat = pricePerSeat;
		this.numberAvailableSeats = numberAvailableSeats;
	}
	public int getId() {
		return this.Id;
	}

	public void setId(int id) {
		this.Id = id;
	}
	
	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getPosterThumbNail() {
		return posterThumbNail;
	}
	public void setPosterThumbNail(String posterThumbNail) {
		this.posterThumbNail = posterThumbNail;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public int getShowRoomID() {
		return showRoomID;
	}
	public void setShowRoomID(int showRoomID) {
		this.showRoomID = showRoomID;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public int getPricePerSeat() {
		return pricePerSeat;
	}
	public void setPricePerSeat(int pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}
	public int getNumberAvailableSeats() {
		return numberAvailableSeats;
	}
	public void setNumberAvailableSeats(int numberAvailableSeats) {
		this.numberAvailableSeats = numberAvailableSeats;
	}

}
