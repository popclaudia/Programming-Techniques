package business_layer;

import java.util.ArrayList;

public interface RestaurantProcessing {
	
	//admin
	/**
	 * 
	 * @pre m!=null
	 * @inv m.getPrice()>0
	 *
	 */
	public void createNewMenuItem(MenuItem m); 
	/**
	 * 
	 * @inv i>0
	 * 
	 */
	public void deleteMenuItem(int i);
	/**
	 * 
	 * @param i
	 * @param c
	 * @param m
	 */
	
	public void editMenuItem(int i,String c,int m);
	
	//waiter
	/**
	 * 
	 * @param o
	 * @param m
	 * @pre m.size()>0
	 */
	public void createNewOrder(Order o, ArrayList<MenuItem> m);
	public void computePriceForOrder(Order o);
	/**
	 *@pre o!=null
	 *@pre m!=null
	 */
	public void generateBill(Order o, ArrayList<MenuItem> m);

}
