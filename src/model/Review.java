package model;

public class Review {
	private int userId;
	private int movieId;
	private String review;
	private int rating;
	private String reviewDate;
	private String userName;
	
	public Review(int userId, int movieId, String review, int rating, String reviewDate, String userName) {
		super();
		this.userId = userId;
		this.movieId = movieId;
		this.review = review;
		this.rating = rating;
		this.reviewDate = reviewDate;
		this.userName = userName;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
		
	public String getuserName(){
		return this.userName;
	}
	
	public void setuserName(String userName){
		this.userName = userName;
	}
	

}
