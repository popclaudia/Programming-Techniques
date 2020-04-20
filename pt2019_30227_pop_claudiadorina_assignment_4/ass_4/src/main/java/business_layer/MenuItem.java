package business_layer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class MenuItem implements Serializable {

	public int computePrice(MenuItem n) {

		return 0;
	}

	public String getName() {

		String name = "";
		return name;
	}

	public int getPrice() {

		return 0;
	}
	public void setName(String s) {
		
	}
	
	public void setPrice(int f) {
		
	}

	public void addProduct(MenuItem p) {

	}

	public String info() {
		return "";
	}

}
