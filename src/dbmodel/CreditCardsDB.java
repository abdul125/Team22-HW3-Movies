package dbmodel;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Transactions;
import utility.DBConnection;


public class CreditCardsDB {
	
	public static double GetCreditCardBalanceByUserID(int userID){
		Connection conn = DBConnection.getConnection();
		String creditCardSql = "select creditcards.Balance from creditcards Where UserId=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		double balance = 0.0;
		try {
			ps = conn.prepareStatement(creditCardSql);
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			while(rs.next()) {
				balance = rs.getDouble("Balance");
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
		return balance;
	}
	
	public static int CheckAndSubmitCreditCardBalance(Transactions t) throws ParseException{
		Connection conn = DBConnection.getConnection();
		String creditCardSql = "SELECT creditcards.UserID, creditcards.Balance from creditcards where creditcards.CardHolderName = ? AND creditcards.CreditCardNumber = ? AND creditcards.CardType = ? AND creditcards.CVV = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		double balance = 0.0;
		int userID = 0;
		int result = 0;
		
		try {
			ps = conn.prepareStatement(creditCardSql);
			ps.setString(1, t.getCardHolderName());
			ps.setString(2, t.getCreditCardNumber());
			ps.setString(3, t.getCardType());
			ps.setString(4, t.getCvv());
			rs = ps.executeQuery();
			System.out.println("First one Executed");
			while(rs.next()) {
				userID = rs.getInt("UserId");
				balance = rs.getDouble("Balance");
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
		
		if (userID !=0 && balance != 0.0){
			if (balance >= t.getTotal()){
				result = subtractBalance(userID,t.getTotal());
			}else{
				result = 2;
			}
		}else {
			result = 0;
		}
		
		return result;
	}
	
//	public static List<Transactions> getCreditCards(int userId) {
//		Connection conn = DBConnection.getConnection();
//		String creditCardSql = "select * from CreditCards where UserId=?";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		ArrayList<Transactions> cards = new ArrayList<Transactions>();
//		try {
//			ps = conn.prepareStatement(creditCardSql);
//			ps.setInt(1, userId);
//			rs = ps.executeQuery();
//			while(rs.next()) {
//				String cardHolderName = rs.getString("CardHolderName");
//				String creditCardNumber = rs.getString("CreditCardNumber");
//				double balance = rs.getDouble("Balance");
//				String cardType = rs.getString("CardType");
//				String cvv = rs.getString("CVV");
//				String experationDate = rs.getString("ExpirationDate");
//				
//				Transactions card = new Transactions(cardHolderName, creditCardNumber, balance, cardType, cvv, experationDate);
//				cards.add(card);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs != null && !rs.isClosed()) {
//					rs.close();
//				}
//				if(ps != null && !ps.isClosed()) {
//					ps.close();
//				}
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//		
//		DBConnection.closeConnection(conn);
//		return cards;
//	}
	
//	public static void insertCreditCard(Transactions card, int userId) {
//		Connection conn = DBConnection.getConnection();
//		String sql = "insert into CreditCards (CardHolderName,CreditCardNumber,Balance,CardType,UserId,CVV,ExpirationDate) "
//				+ "values (?,?,?,?,?,?,?)";
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, card.getCardHolderName());
//			ps.setString(2, card.getCreditCardNumber());
//			BigDecimal bd = new BigDecimal(card.getBalance());
//			ps.setBigDecimal(3, bd);
//			ps.setString(4, card.getCardType());
//			ps.setInt(5, userId);
//			ps.setString(6, card.getCvv());
//			ps.setString(7, card.getExpirationDate());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs != null && !rs.isClosed()) {
//					rs.close();
//				}
//				if(ps != null && !ps.isClosed()) {
//					ps.close();
//				}
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
//		
//		DBConnection.closeConnection(conn);
//	}
	
	public static int subtractBalance(int userID, double cost){
		int result = 0;
		BigDecimal bigDecBal = new BigDecimal(cost);
		
		Connection conn = DBConnection.getConnection();
		String sql = "UPDATE creditcards SET Balance = Balance - ? WHERE userID=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setBigDecimal(1, bigDecBal);
			ps.setInt(2, userID);
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
	
	public static int refundCard(String cardNumber, int refundAmount) {
		Connection conn = DBConnection.getConnection();
		String balanceSql = "UPDATE creditcards set Balance = Balance + ? where CreditCardNumber = ?";
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = conn.prepareStatement(balanceSql);
			BigDecimal bd = new BigDecimal(refundAmount);
			ps.setBigDecimal(1, bd);
			ps.setString(2, cardNumber);
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

	public static String GetCreditCardByOrderID(int orderID){
		
		Connection conn = DBConnection.getConnection();
		String creditCardSql = "SELECT orders.CreditCardNumber FROM `orders` WHERE orders.Id = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String number = "";
		
		try {
			ps = conn.prepareStatement(creditCardSql);
			ps.setInt(1, orderID);
			rs = ps.executeQuery();
			System.out.println("First one Executed");
			while(rs.next()) {
				number = rs.getString("CreditCardNumber");
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
		
		return number;
	}
}
