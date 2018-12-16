package utility;

import java.util.ArrayList;

import dbmodel.CreditCardsDB;
import dbmodel.MovieShowingDB;
import dbmodel.OrdersDB;
import model.Order;
import model.OrderItemDetails;
import model.ShoppingCartItem;

public class OrderHelper {
	
	public static int AddOrder(Order o){
		return OrdersDB.AddOrder(o);
	}
	
	public static ArrayList<Order> GetAllOrdersByUserID(int userID){
		return OrdersDB.GetAllOrdersByUserID(userID);
	}
	
	public static void AddOrderItems(ArrayList<ShoppingCartItem> sc, int orderID){
		OrdersDB.AddOrderItems(sc, orderID);
	}
	
	public static ArrayList<OrderItemDetails> GetOrderItemsByOrderID(int orderId){
		return OrdersDB.GetOrderItemsByOrderID(orderId);
	}
	
	public static OrderItemDetails GetOrderItemByOrderIDAndItemNumber(int orderID, int item){
		return OrdersDB.GetOrderItemByOrderIDAndItemNumber(orderID, item);
	}
	
	public static int CancelOrder(OrderItemDetails d){
		String creditCard = CreditCardsDB.GetCreditCardByOrderID(d.getId());
		int result = 0;
		
		if (!creditCard.isEmpty()){
			result = CreditCardsDB.refundCard(creditCard, d.getPrice());
		}else {
			return 2;
		}
		
		System.out.println(result);
		
		if (result != 0){
			result = MovieShowingDB.AddTicketsToMovieShowing(d.getShowingId(), d.getTicketQuantity());
		}else {
			return 2;
		}
		
		System.out.println(result);
		
		if (result != 0){
			result = OrdersDB.UpdateOrderTotalCost(d.getId(), d.getPrice());
		}else{
			return 3;
		}
		
		System.out.println(result);
		
		if (result != 0){
			result = OrdersDB.DeleteOrderItemFromOrder(d.getId(), d.getShowingId(), d.getTicketQuantity());
		}else{
			return 4;
		}
		
		System.out.println(result);
		
		if (result != 0){
			return result;
		}else{
			return 5;
		}
		
		
	}
}
