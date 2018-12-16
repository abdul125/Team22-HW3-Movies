package utility;

import java.util.ArrayList;

import model.Movie;
import model.MovieShowing;
import model.Review;
import model.MovieSearchResult;

import dbmodel.MoviesDB;
import dbmodel.ReviewDB;
import dbmodel.MovieShowingDB;

public class MovieHelper {

	///////////////////////////////////////////////
	//////// Private Method Section ///////////////
	///////////////////////////////////////////////
	
	private static Movie getMovie (String movie){
		return MoviesDB.getMovieByName(movie);
	}
	
	private static ArrayList<MovieSearchResult> getMovieSearchResult(int theatreID, String movie){
		return MoviesDB.SearchMovieResult(theatreID, movie);	
	}
	
	private static MovieShowing getMovieShowingByMovieName(String movie){
		return MovieShowingDB.getMovieShowingByMovieName(movie);
	}
	
	private static ArrayList<Review> getReviewsByMovieID(int id){
		return ReviewDB.GetReviews(id);
	}
	
	private static int addReviewByMovieID(int movieID, int userID, int rating, String review){
		return ReviewDB.AddReviewByMovieID(movieID, userID, rating, review);
	}
	///////////////////////////////////////////////
	//////// End Private Method Section ///////////
	///////////////////////////////////////////////
	
	
	///////////////////////////////////////////////
	//////// Public Method Section ///////////////
	///////////////////////////////////////////////
	
	/*
	 * GetMovieByName
	 */
	public static Movie GetMovieByName(String name){
		return getMovie(name);
	}
		
	/*
	 * GetMovieSearchResults params = theatreid and movieName
	 */
	public static ArrayList<MovieSearchResult> GetMovieSearchResults(String theatreID, String movie){
		ArrayList<MovieSearchResult> rs = new ArrayList<MovieSearchResult>();
		if (isInteger(theatreID) && movie != null){
			rs = getMovieSearchResult(Integer.parseInt(theatreID), movie);
		}else {
			//to-do if there is no search params
		}
		return rs;
	}

	public static MovieShowing GetMovieShowingByMovieName(String movieName){
		return getMovieShowingByMovieName(movieName);
	}
	
	public static ArrayList<Review> GetReviewsByMovieID(int ID){
		return getReviewsByMovieID(ID);
	}
	
	public static int AddReviewByMovieID(int movieID, int userID, int rating, String review){
		return addReviewByMovieID(movieID, userID, rating, review);
	}
	
	public static void RemoveTicketsFromMovieShowing(int showingID, int tickets){
		MovieShowingDB.RemoveTicketsFromShowing(showingID, tickets);
	}
	
	/*
	 * Checks is the given string can be converted to an integer
	 */
	public static boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( NumberFormatException e ) {
	        return false;
	    }
	}
	
	///////////////////////////////////////////////
	//////// End Public Method Section ///////////
	///////////////////////////////////////////////
	
}
