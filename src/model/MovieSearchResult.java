package model;

public class MovieSearchResult {
	private String name;
	private String theatreBuildingName;
	private String showTime;
	private int theatreNumber;
	private int price;
	private int numberSeats;
	private String thumbNail;
	
		
	public MovieSearchResult(String name, String theatreBuildingName, String showTime, int theatreNumber, int price, int numberSeats,
			String thumbNail) {
		super();
		this.name = name;
		this.theatreBuildingName = theatreBuildingName;
		this.showTime = showTime;
		this.theatreNumber = theatreNumber;
		this.price = price;
		this.numberSeats = numberSeats;
		this.thumbNail = thumbNail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTheatreBuildingName() {
		return theatreBuildingName;
	}
	public void setTheatreBuildingName(String theatreBuildingName) {
		this.theatreBuildingName = theatreBuildingName;
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
	public int getNumberSeats() {
		return numberSeats;
	}
	public void setNumberSeats(int numberSeats) {
		this.numberSeats = numberSeats;
	}
	public String getThumbNail() {
		return thumbNail;
	}
	public void setThumbNail(String thumbNail) {
		this.thumbNail = thumbNail;
	}
	
	public int getTheatreNumber(){
		return theatreNumber;
	}
	
	public void setTheatreNumber(int theatreNumber){
		this.theatreNumber = theatreNumber;
	}
}
