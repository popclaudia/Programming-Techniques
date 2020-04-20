package businessLayer;

import javax.swing.table.DefaultTableModel;

import dataAccessLayer.OrderDAO;
import dataAccessLayer.ProductDAO;
import model.Orders;
import model.Product;

public class OrderBL {
	
	public OrderBL() {
	}
	
    OrderDAO o=new OrderDAO();
	
	
	public DefaultTableModel findAll() {
		o.findAll();
		return o.retrieveProperties();
	
	}
	
	public int insertOrder(Orders oo) {
		
		return o.insert(oo);
	}
	

}
