package business_layer;

public class Order {
	private int orderID;
	private int price;
	private String date;
	private int table;

	public Order(int orderID, int price, String date, int table) {
		this.orderID = orderID;
		this.price = price;
		this.date = date;
		this.table = table;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderID != other.orderID)
			return false;
		if (price != other.price)
			return false;
		if (table != other.table)
			return false;
		return true;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTable() {
		return table;
	}

	public void setTable(int table) {
		this.table = table;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + orderID;
		result = prime * result + price;
		result = prime * result + table;
		return result;
	}

	@Override
	public String toString() {
		return "orderID:" + orderID + ", price:" + price + ", date:" + date + ", table:" + table ;
	}
	
	
}
