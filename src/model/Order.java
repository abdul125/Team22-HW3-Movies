package model;

public class Order {
		private int Id;  
		private int CustomerId;
		private double TotalCost;
		private String OrderDate;
		private String ShippingAddress;
		private String BillingAddress;
		private String CreditCardNumber;		
		
		public Order(){
			
		}
		
		public Order(int CustomerId,double TotalCost,String OrderDate,String ShippingAddress,String BillingAddress,String CreditCardNumber,int Id){
			super();
			this.CustomerId=CustomerId;
			this.TotalCost=TotalCost;
			this.OrderDate=OrderDate;
			this.ShippingAddress=ShippingAddress;
			this.BillingAddress=BillingAddress;
			this.CreditCardNumber=CreditCardNumber;
			this.Id=Id;
		}
		public int getCustomerId() {
			return CustomerId;
		}
		public void setCustomerId(int customerId) {
			CustomerId = customerId;
		}
		public double getTotalCost() {
			return TotalCost;
		}
		public void setTotalCost(double totalCost) {
			TotalCost = totalCost;
		}
		public String getOrderDate() {
			return OrderDate;
		}
		public void setOrderDate(String orderDate) {
			OrderDate = orderDate;
		}
		public String getShippingAddress() {
			return ShippingAddress;
		}
		public void setShippingAddress(String shippingAddress) {
			ShippingAddress = shippingAddress;
		}
		public String getBillingAddress() {
			return BillingAddress;
		}
		public void setBillingAddress(String billingAddress) {
			BillingAddress = billingAddress;
		}
		public String getCreditCardNumber() {
			return CreditCardNumber;
		}
		public void setCreditCardNumber(String creditCardNumber) {
			CreditCardNumber = creditCardNumber;
		}
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		
}
