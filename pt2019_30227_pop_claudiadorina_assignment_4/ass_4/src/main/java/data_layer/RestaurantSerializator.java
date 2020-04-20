package data_layer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import business_layer.MenuItem;
import business_layer.Order;

public class RestaurantSerializator {

	String filename = "menu.txt";

	public void serialize(List<MenuItem> menu) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(menu);
			out.close();
			file.close();

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
		}

	}

	public ArrayList<MenuItem> deserialize() {
		ArrayList<MenuItem> items =new ArrayList<MenuItem>();
		try {

			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);

			items =  (ArrayList<MenuItem>) in.readObject();
			in.close();
			file.close();

		}catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return items;
	}

}
