package dbmodel;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Movie;
import model.MovieSearchResult;
import sun.misc.BASE64Encoder;
import utility.DBConnection;

public class MoviesDB {

	public static Movie getMovieByName(String MovieName) {
		Connection conn = DBConnection.getConnection();
		String sqlCheckExistence = "select * from movies where MovieName=?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		Movie m = null;

		try {
			ps = conn.prepareStatement(sqlCheckExistence);
			ps.setString(1, MovieName);
			rs = ps.executeQuery();
			System.out.println("Executed");
			while(rs.next()) {
				int id = rs.getInt("Id");
				String name = rs.getString("MovieName");
				String Description = rs.getString("Description");
				Blob ph = rs.getBlob("Thumbnail");
				byte TN[] = ph.getBytes(1, (int) ph.length());
				String thumbNail = ConvertThumbNailToString(TN);
				String Rating = rs.getString("Rating");

				m = new Movie(id, name, thumbNail, Description, Rating);
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
	public static ArrayList<MovieSearchResult> SearchMovieResult(int theatreID, String mn){
		Connection conn = DBConnection.getConnection();
		String sqlCheckExistence = "SELECT movies.MovieName, movies.Thumbnail, theatreBuildings.Name, theatreBuildings.Id, movieShowing.StartTime, movieShowing.Price, Showrooms.availableSeats FROM movies INNER JOIN movieShowing ON movieShowing.movieID = movies.id INNER JOIN Showrooms ON Showrooms.Id = movieShowing.showroomID INNER JOIN theatreBuildings ON theatreBuildings.Id = Showrooms.theatreBuilding WHERE movies.MovieName=? AND theatreBuildings.Id=?";
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<MovieSearchResult> result = new ArrayList<MovieSearchResult>();
		MovieSearchResult m = null;

		try {
			ps = conn.prepareStatement(sqlCheckExistence);
			ps.setString(1, mn);
			ps.setInt(2, theatreID);
			rs = ps.executeQuery();
			System.out.println("Executed");
			while(rs.next()) {
				String name = rs.getString("MovieName");
				String theatreName = rs.getString("Name");
				Blob ph = rs.getBlob("Thumbnail");
				byte TN[] = ph.getBytes(1, (int) ph.length());
				String thumbNail = ConvertThumbNailToString(TN);
				String date = rs.getDate("StartTime").toString();
				int price = rs.getInt("Price");
				int availableSeats = rs.getInt("availableSeats");
				int theatreNumber = rs.getInt("Id");
				
				m = new MovieSearchResult(name, theatreName, date, theatreNumber, price, availableSeats, thumbNail);
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
