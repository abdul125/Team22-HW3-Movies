package dbmodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movie;
import model.Transactions;
import model.User;
import utility.DBConnection;
import model.Theatres;

public class TheatresDB {

	public static ArrayList<Theatres> getTheatres() {
		Connection conn = DBConnection.getConnection();
		String userSql = "select * from theatreBuildings";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Theatres theatre = null;
		ArrayList<Theatres> theatres = new ArrayList<Theatres>();
		int id = -1;

		try {
			ps = conn.prepareStatement(userSql);
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("Id");
				String name = rs.getString("Name");
				String address = rs.getString("Address");
				int ownerID = rs.getInt("ownerID");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String pc = rs.getString("PostalCode");

				theatre = new Theatres(id,name,address,ownerID,city,state,pc);
				theatres.add(theatre);
				theatre = null;
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

		DBConnection.closeConnection(conn);

		return theatres;
	}

}
