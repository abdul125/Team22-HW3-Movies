package dbmodel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.User;
import model.Transactions;
import utility.DBConnection;

public class UsersDB
{
	public static boolean userExists (String username) {
		Connection conn = DBConnection.getConnection();
		boolean result = false;
		String query = "SELECT Username FROM users where Username = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				result = true;
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static User getUser(String username) {
		Connection conn = DBConnection.getConnection();
		String userSql = "select * from users where Username = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<Transactions> cards;
		int id = -1;

		try {
			ps = conn.prepareStatement(userSql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("Id");
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String postalCode = rs.getString("PostalCode");
				String emailAddress = rs.getString("EmailAddress");
				String phoneNumber = rs.getString("PhoneNumber");
				String birthday = rs.getString("Birthday");
				int type = rs.getInt("Type");
				int status = rs.getInt("Status");
				int numOfVisits = rs.getInt("NumOfVisits");
				username = rs.getString("Username");
				String password = rs.getString("Password");

				user = new User(id, username, password, firstName, lastName,
						address, city, state, postalCode, emailAddress,
						phoneNumber, birthday, type, status, numOfVisits);
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

		return user;
	}

	public static User getUser(int id) {
		Connection conn = DBConnection.getConnection();
		String userSql = "select * from users where Id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		List<Transactions> cards;

		try {
			ps = conn.prepareStatement(userSql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("FirstName");
				String lastName = rs.getString("LastName");
				String address = rs.getString("Address");
				String city = rs.getString("City");
				String state = rs.getString("State");
				String postalCode = rs.getString("PostalCode");
				String emailAddress = rs.getString("EmailAddress");
				String phoneNumber = rs.getString("PhoneNumber");
				String birthday = rs.getString("Birthday");
				int type = rs.getInt("Type");
				int status = rs.getInt("Status");
				int numOfVisits = rs.getInt("NumOfVisits");
				String username = rs.getString("Username");
				String password = rs.getString("Password");

				user = new User(id, username, password, firstName, lastName,
						address, city, state, postalCode, emailAddress,
						phoneNumber, birthday, type, status, numOfVisits);
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

		return user;
	}

	public static void registerUser(User user) {
		Connection conn = DBConnection.getConnection();
		String sqlInsert = "insert into users "
					+ "(Username,Password,FirstName,LastName,Address,City,State,PostalCode,EmailAddress,PhoneNumber,Birthday) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
			try {
				ps = conn.prepareStatement(sqlInsert, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getPassword());
				ps.setString(3, user.getFirstName());
				ps.setString(4, user.getLastName());
				ps.setString(5, user.getAddress());
				ps.setString(6, user.getCity());
				ps.setString(7, user.getState());
				ps.setString(8, user.getPostalCode());
				ps.setString(9, user.getEmail());
				ps.setString(10, user.getPhoneNumber());
				ps.setString(11, user.getBirthday());
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();

			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if(ps != null && !ps.isClosed()) {
						ps.close();
				}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		DBConnection.closeConnection(conn);

	}

	public static void updatePassword(User user) {
		Connection conn = DBConnection.getConnection();
		String updatePass = "UPDATE users SET Password=? WHERE Username=?  ";

		PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(updatePass);
				ps.setString(1, user.getPassword());
				ps.setString(2, user.getUserName());
	

				ps.executeUpdate();
				

			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}


		//System.out.println(user.getUserName()+ " //>> "+user.getPassword());
		DBConnection.closeConnection(conn);

	}

	public static boolean validateUser(User user) {
		Connection conn = DBConnection.getConnection();
		boolean validUser = false;
		String sql = "select Id from users where Username=? and Password=?";
		int id = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("Id");
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

		if(id != 0) {
			validUser = true;
		}

		return validUser;
	}

	public static int GetUserIDByUserName(String username){
		return getUserIDByUserName(username);
	}

	private static int getUserIDByUserName(String username){
		Connection conn = DBConnection.getConnection();
		String sql = "select Id from users where Username=?";
		int id = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt("Id");
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

		return id;
	}

}
