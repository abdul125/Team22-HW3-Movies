package dbmodel;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.MovieShowing;
import sun.misc.BASE64Encoder;
import utility.DBConnection;

public class MovieShowingDB {
	public static MovieShowing getMovieShowingByMovieName(String MovieName) {
		Connection conn = DBConnection.getConnection();
		String sqlCheckExistence = "SELECT movieShowing.Id SHOWINGID, movies.id MOVIEID, movies.MovieName, movies.Description, movies.Rating, movies.Thumbnail, theatreBuildings.Name, movieShowing.showroomID, movieShowing.StartTime, movieShowing.Price, Showrooms.availableSeats FROM movies INNER JOIN movieShowing ON movies.id = movieShowing.movieID INNER JOIN Showrooms ON Showrooms.Id = movieShowing.showroomID INNER JOIN theatreBuildings ON theatreBuildings.Id = Showrooms.theatreBuilding where MovieName=?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		MovieShowing m = null;

		try {
			ps = conn.prepareStatement(sqlCheckExistence);
			ps.setString(1, MovieName);
			rs = ps.executeQuery();
			while(rs.next()) {
				int ID = rs.getInt("SHOWINGID");
				int movieID = rs.getInt("MOVIEID");
				String name = rs.getString("MovieName");
				String Description = rs.getString("Description");
				String rating = rs.getString("Rating");
				Blob ph = rs.getBlob("Thumbnail");
				byte TN[] = ph.getBytes(1, (int) ph.length());
				String thumbNail = ConvertThumbNailToString(TN);
				String theatreName = rs.getString("Name");
				int showRoomID = rs.getInt("showroomID");
				String showTime = rs.getDate("StartTime").toString();
				int price = rs.getInt("Price");
				int numberAvailableSeats = rs.getInt("availableSeats");

				m = new MovieShowing(ID, movieID,name, Description, rating, thumbNail, theatreName, showRoomID, showTime, price, numberAvailableSeats);
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
		return m;
	}
	
	public static void RemoveTicketsFromShowing(int showingID, int tickets){
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE movieShowing SET NumberPurchased = NumberPurchased - ? WHERE Id = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tickets);
			ps.setInt(2, showingID);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps != null && !ps.isClosed()) {
					ps.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		DBConnection.closeConnection(conn);
	}
	
	public static int AddTicketsToMovieShowing(int showingID, int tickets){
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE `Showrooms` SET availableSeats = availableSeats + ? WHERE Showrooms.Id = (SELECT movieShowing.showroomID FROM movieShowing WHERE movieShowing.Id = ?)";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tickets);
			ps.setInt(2, showingID);
			ps.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = 0;
		}finally {
			try {
				if(ps != null && !ps.isClosed()) {
					ps.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				result = 0;
			}
		}
		DBConnection.closeConnection(conn);
		return result;
	}
	
	/*
	 * Converts a byte[] thumbnail into a usable String for jsp
	 */
	public static String ConvertThumbNailToString(byte[] t){
		BASE64Encoder base64Encoder = new BASE64Encoder();
		StringBuilder sb = new StringBuilder();
		sb.append("data:image/png;base64,");
		sb.append(base64Encoder.encode(t));
		return sb.toString();	
	}
}
