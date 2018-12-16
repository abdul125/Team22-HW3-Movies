package dbmodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Review;
import utility.DBConnection;

public class ReviewDB {
	public static ArrayList<Review> GetReviews(int movieID){
		return getReviews(movieID);
	}

	private static ArrayList<Review> getReviews(int movieID){
		Connection conn = DBConnection.getConnection();
		String query = "Select customerreviews.userID, customerreviews.movieID, customerreviews.ReviewDate, customerreviews.Rating, customerreviews.Review, users.Username FROM customerreviews INNER join movies on movies.id=customerreviews.movieID INNER JOIN users ON users.Id = customerreviews.userID WHERE movies.id=? ORDER BY customerreviews.Id DESC";
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<Review> result = new ArrayList<Review>();
		Review m = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, movieID);
			rs = ps.executeQuery();
			 //System.out.println("Executed"); testing
			while(rs.next()) {
				int userID= rs.getInt("userID");
				int movieId=rs.getInt("movieID");
				String ReviewDate = rs.getString("ReviewDate");
				int Rating = rs.getInt("Rating");
				String review = rs.getString("Review");
				String userName = rs.getString("userName");
				
				m = new Review(userID,movieId,ReviewDate,Rating,review,userName);
				result.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				if(ps != null && !ps.isClosed()) {
					ps.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return result;		
	}
	
	
	public static int AddReviewByMovieID(int movieID, int userID, int rating, String review){
		return addReviewByMovieID(movieID, userID, rating, review);
	}
	
	private static int addReviewByMovieID(int movieID, int userID, int Rating, String Review){
		Connection conn = DBConnection.getConnection();
		String query = "INSERT INTO customerreviews (movieID, userID, ReviewDate, Rating, Review) VALUES (?,?,?,?,?)";
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		int check = 0;
		try {
			String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, movieID);
			ps.setInt(2, userID);
			ps.setString(3, date);
			ps.setInt(4, Rating);
			ps.setString(5, Review);
			rs = ps.getGeneratedKeys();
			check = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
				if(ps != null && !ps.isClosed()) {
					ps.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		DBConnection.closeConnection(conn);
		return check;
	}
}
