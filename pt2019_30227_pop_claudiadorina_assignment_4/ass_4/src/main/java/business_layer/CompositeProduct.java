package business_layer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeProduct extends MenuItem {
	private String cname;
	private int cprice = 0;
	private ArrayList<MenuItem> composit = new ArrayList<MenuItem>();

	public CompositeProduct(String name, int price) {

		this.cname = name;
		this.cprice = price;
	}

	public void addProduct(MenuItem newItem) {
		composit.add(newItem);

	}

	public String getName() {
		return cname;
	}

	public int getPrice() {
		return cprice;
	}
public void setName(String s) {
		this.cname=s;
	}
	
	public void setPrice(int f) {
		this.cprice=f;
	}
	public int computePrice(MenuItem  cp) {

		for (MenuItem m : composit) {
			cprice += m.getPrice();
		}

		return cprice;
	}

	public String info() {
		String name="";
		name+=getName();
		name+="\n";
	//	System.out.println("Name: " + getName() + " Price: " + getPrice());
		Iterator i = composit.iterator();
		while (i.hasNext()) {
			MenuItem inf = (MenuItem) i.next();
			//System.out.println(inf.getName());
			name+=" -"+inf.getName();
			//inf.info();
		}
		return name;
	}
}