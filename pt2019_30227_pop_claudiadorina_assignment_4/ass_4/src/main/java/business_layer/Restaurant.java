package business_layer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Observable;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import business_layer.BaseProduct;
import business_layer.CompositeProduct;
import business_layer.MenuItem;
import data_layer.RestaurantSerializator;
import presentation_layer.GuiU;

public class Restaurant extends JFrame implements RestaurantProcessing {

	public ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
	public HashMap<Order, ArrayList<MenuItem>> hmap = new HashMap<Order, ArrayList<MenuItem>>();
	RestaurantSerializator rs = new RestaurantSerializator();
	GuiU user;
	int count = 0;
	int countOrders = 0;

	public Restaurant(GuiU u) {
		this.menu = rs.deserialize();
		this.user = u;
		this.user.a.view(new View());
		this.user.a.add(new Add());
		this.user.a.edit(new Edit());
		this.user.a.delete(new Delete());
		this.user.w.addO(new AddOrder());
		this.user.w.placeO(new PlaceOrder());
		this.user.w.viewO(new ViewOrder());
		this.user.w.bill(new Bill());
	}

	class View implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Vector<String> header = new Vector<String>();
			Vector<Vector<Object>> content = new Vector<Vector<Object>>();
			count = 0;
			header.add("Nr.");
			header.add("Product");
			header.add("Price");
			for (MenuItem m : menu) {
				count++;
				Vector<Object> vector = new Vector<Object>();
				vector.add(count);
				vector.add(m.info());
				vector.add(m.getPrice());
				content.add(vector);

				System.out.println(vector);
			}
			user.a.menu(new DefaultTableModel(content, header));
		}
	}
	
	class Add implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String name = user.a.getName();
			int price = Integer.parseInt(user.a.getPrice());
			assert price>0:"Negative price";
			MenuItem m = null;
			if (user.a.base.isSelected())
				m = new BaseProduct(name, price);
			else if (user.a.compose.isSelected())
				m = new CompositeProduct(name, price);
			createNewMenuItem(m);
		}
	}

	class Edit implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String name;
			int price;
			name = user.a.getN();
			price = Integer.parseInt(user.a.getP());
			editMenuItem(user.a.getSelectedItem1(), name, price);

		}
	}

	class Delete implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			deleteMenuItem(user.a.getSelectedItem2());
		}
	}

	class AddOrder implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			int nr = Integer.parseInt(user.w.getnr());
			user.w.combo(menu, nr);
		}
	}

	class PlaceOrder implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			countOrders++;
			int price = 0;
			int nr = Integer.parseInt(user.w.getnr());
			int table = Integer.parseInt(user.w.gettable());
			String date = new Date().toString();
			ArrayList<MenuItem> meal = new ArrayList<MenuItem>();
			for (int i = 0; i < nr; i++) {
				price += menu.get(user.w.comboOrder.get(i).getSelectedIndex()).getPrice();
				meal.add(menu.get(user.w.comboOrder.get(i).getSelectedIndex()));
			}
			// System.out.println(price);
			Order o = new Order(countOrders, price, date, table);
			createNewOrder(o, meal);

		}
	}

	class ViewOrder implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Vector<String> header = new Vector<String>();
			Vector<Vector<Object>> content = new Vector<Vector<Object>>();
			header.add("Key");
			header.add("Value");
			for (Order o : hmap.keySet()) {
				String key = o.toString();
				String value = "~";
				ArrayList<MenuItem> m = hmap.get(o);
				for (MenuItem a : m) {
					value += a.getName() + " ~ ";
				}
				Vector<Object> vector = new Vector<Object>();
				vector.add(key);
				vector.add(value);
				content.add(vector);
				System.out.println(o + " " + value);
			}
			user.w.order(new DefaultTableModel(content, header));

		}
	}

	class Bill implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			int price = 0;
			int nr = Integer.parseInt(user.w.getnr());
			int table = Integer.parseInt(user.w.gettable());
			String date = new Date().toString();
			ArrayList<MenuItem> meal = new ArrayList<MenuItem>();
			for (int i = 0; i < nr; i++) {
				price += menu.get(user.w.comboOrder.get(i).getSelectedIndex()).getPrice();
				meal.add(menu.get(user.w.comboOrder.get(i).getSelectedIndex()));
			}
			Order o = new Order(countOrders, price, date, table);
			generateBill(o, meal);
		}
	}

	public void createNewMenuItem(MenuItem m) {
		menu.add(m);
		rs.serialize(menu);
	}

	public void deleteMenuItem(int i) {
		System.out.println(i - 1);
		int size= menu.size();
		menu.remove(i - 1);
		assert menu.size()==size-1:"Error while deleting.";
		rs.serialize(menu);
	}

	public void editMenuItem(int i, String name, int price) {
		menu.get(i - 1).setName(name);
		menu.get(i - 1).setPrice(price);
		rs.serialize(menu);
	}

	public void createNewOrder(Order o, ArrayList<MenuItem> m) {
		hmap.put(o, m);
		for (MenuItem i : m)
			if (i.getClass().getName().equals( "business_layer.CompositeProduct")) {
				user.c.update(new Observable(), new Object());
				break;
			}
	}

	public void computePriceForOrder(Order o) {
	}

	public void generateBill(Order o, ArrayList<MenuItem> m) {
		try {
			File file = new File("Bill" + (count++) + ".txt");
			file.createNewFile();
			FileWriter w = new FileWriter(file, true);

			w.write("@PlanetGRILLRestaurants\n\n");
			w.write("Date: " + o.getDate() + "\n\n");
			for (MenuItem i : m) {
				w.write(i.getName() + " ..... " + i.getPrice() + "\n");
			}
			w.write("\nTotal........" + o.getPrice());
			w.flush();
			w.close();

			JOptionPane.showMessageDialog(this, "Bill successfully generated!");
		} catch (IOException e) {

		}
	}
}
