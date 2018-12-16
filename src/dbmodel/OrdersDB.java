package dbmodel;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import model.Order;
import model.OrderItemDetails;
import model.ShoppingCartItem;
import utility.DBConnection;

public class OrdersDB {

	public static int AddOrder(Order o){
		Connection conn = DBConnection.getConnection();
		String query = "INSERT INTO orders (CustomerId, TotalCost, OrderDate, BillingAddress, CreditCardNumber) VALUES (?,?,?,?,?)";		
		PreparedStatement ps = null;
		ResultSet rs = null;

		int orderID = 0;
		try {
			ps = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, o.getCustomerId());
			ps.setInt(2, (int)o.getTotalCost());
			ps.setString(3, o.getOrderDate());
			ps.setString(4, o.getBillingAddress());
			ps.setString(5, o.getCreditCardNumber());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			while(rs.next()) {
				orderID = rs.getInt(1);
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

		return orderID;
	}
	
	public static ArrayList<Order> GetAllOrdersByUserID(int userID){
		Connection conn = DBConnection.getConnection();
		String query = "Select * FROM orders WHERE orders.CustomerID = ?";		
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<Order> ords = new ArrayList<Order>();
		Order o = null;
		
		try {
			ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("Id");
				int customerID = rs.getInt("CustomerId");			
				String CreditCardNumber = rs.getString("CreditCardNumber");
				double cost = (double) rs.getInt("TotalCost");
				String OrderDate = rs.getString("OrderDate");
				String BillingAddress = rs.getString("BillingAddress");
				
				o = new Order(customerID, cost, OrderDate, BillingAddress, BillingAddress, CreditCardNumber, id);
				ords.add(o);
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
		return ords;
	}
	
	public static void AddOrderItems(ArrayList<ShoppingCartItem> sc, int orderID){
		Connection conn = DBConnection.getConnection();
		String query = "INSERT INTO orderitems (OrderId, ShowingId, Quantity) VALUES ((Select orders.Id FROM orders WHERE orders.Id = ?),(SELECT movieShowing.Id FROM movieShowing WHERE movieShowing.Id = ?),?)";		
		
		for(ShoppingCartItem item : sc){
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1, orderID);
				ps.setInt(2, item.getShowingId());
				ps.setInt(3, item.getTicketQuantity());
				ps.executeUpdate();
				rs = ps.getGeneratedKeys();
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
			MovieShowingDB.RemoveTicketsFromShowing(item.getShowingId(), item.getTicketQuantity());
		}		
		DBConnection.closeConnection(conn);	
	}
	
	public static ArrayList<OrderItemDetails> GetOrderItemsByOrderID(int orderID){
		Connection conn = DBConnection.getConnection();
		String query = "Select orders.ID ORDERID, orders.TotalCost TOTALPRICE, movies.id, movies.MovieName, orderitems.Quantity, theatreBuildings.Name, movieShowing.StartTime, movieShowing.Id, movieShowing.Price FROM orders INNER JOIN orderitems ON orderitems.OrderId = orders.Id INNER JOIN movieShowing ON movieShowing.Id = orderitems.ShowingID INNER JOIN movies on movies.id = movieShowing.movieID INNER JOIN Showrooms on Showrooms.Id = movieShowing.showroomID INNER JOIN theatreBuildings ON theatreBuildings.Id = Showrooms.theatreBuilding WHERE orders.Id = ?";		
		PreparedStatement ps = null;
		ResultSet rs = null;

		ArrayList<OrderItemDetails> temp = new ArrayList<OrderItemDetails>();
		OrderItemDetails item = null;
	
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		
		try {
			ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, orderID);
			rs = ps.executeQuery();
			while(rs.next()) {
				int orderId = rs.getInt("ORDERID");
				int movieId = rs.getInt("id");
				String MovieName = rs.getString("MovieName");
				int quantity = rs.getInt("Quantity");
				String theatreName = rs.getString("Name");
				String showTime = formatter.format(rs.getDate("StartTime"));
				int showingID = rs.getInt("Id");
				int price = rs.getInt("Price") * quantity;
				int totalPrice = rs.getInt("TOTALPRICE");
				
				item = new OrderItemDetails(orderId,movieId, quantity, MovieName, theatreName, showTime, showingID, price, totalPrice);
				temp.add(item);
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
		return temp;
	}
	
	public static OrderItemDetails GetOrderItemByOrderIDAndItemNumber(int orderID, int itemNumber){
		Connection conn = DBConnection.getConnection();
		String query = "Select orders.ID ORDERID, orders.TotalCost TOTALPRICE, movies.id, movies.MovieName, orderitems.Quantity, theatreBuildings.Name, movieShowing.StartTime, movieShowing.Id SHOWINGID, movieShowing.Price FROM orders INNER JOIN orderitems ON orderitems.OrderId = orders.Id INNER JOIN movieShowing ON movieShowing.Id = orderitems.ShowingID INNER JOIN movies on movies.id = movieShowing.movieID INNER JOIN Showrooms on Showrooms.Id = movieShowing.showroomID INNER JOIN theatreBuildings ON theatreBuildings.Id = Showrooms.theatreBuilding WHERE orders.Id = ?";		
		PreparedStatement ps = null;
		ResultSet rs = null;

		OrderItemDetails item = null;
	
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		int count = 1;
		try {
			ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, orderID);
			rs = ps.executeQuery();
			while(rs.next()) {
				if (count == itemNumber){
					int orderId = rs.getInt("ORDERID");
					int movieId = rs.getInt("id");
					String MovieName = rs.getString("MovieName");
					int quantity = rs.getInt("Quantity");
					String theatreName = rs.getString("Name");
					String showTime = formatter.format(rs.getDate("StartTime"));
					int showingID = rs.getInt("SHOWINGID");
					int price = rs.getInt("Price") * quantity;
					int totalPrice = rs.getInt("TOTALPRICE");
					
					item = new OrderItemDetails(orderId,movieId, quantity, MovieName, theatreName, showTime, showingID, price, totalPrice);
				}
				count ++;
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
		return item;
	}
	
	
	public static int UpdateOrderTotalCost(int orderID, int RefundAmount){		
		Connection conn = DBConnection.getConnection();
		String balanceSql = "Update orders SET orders.TotalCost = orders.TotalCost - ?  WHERE orders.Id = ?";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(balanceSql);
			ps.setInt(1, RefundAmount);
			ps.setInt(2, orderID);
			ps.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null && !ps.isClosed()) {
					ps.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		DBConnection.closeConnection(conn);
		return result;
	}
	
	public static int DeleteOrderItemFromOrder(int orderID, int showingID, int Quantity){
		Connection conn = DBConnection.getConnection();
		System.out.println("DeleteOrderItem" + orderID + " " + showingID + " " + Quantity );
		String balanceSql = "DELETE FROM orderitems WHERE orderitems.OrderId = ? AND orderitems.ShowingID = ? AND orderitems.Quantity = ?";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(balanceSql);
			ps.setInt(1, orderID);
			ps.setInt(2, showingID);
			ps.setInt(3, Quantity);
			ps.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null && !ps.isClosed()) {
					ps.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		DBConnection.closeConnection(conn);
		return result;
	}
}
