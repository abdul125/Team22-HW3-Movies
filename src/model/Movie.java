package model;


public class Movie {
	private int id;
	private String movieName;
	private String thumbnail;
	private String description;
	private String rating;

	public Movie(int id, String movieName, String thumbnail, String description, String rating) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.thumbnail = thumbnail;
		this.description = description;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
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
	

}
