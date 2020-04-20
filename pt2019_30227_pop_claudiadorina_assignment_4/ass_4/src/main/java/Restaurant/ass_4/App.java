package Restaurant.ass_4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import business_layer.BaseProduct;
import business_layer.CompositeProduct;
import business_layer.MenuItem;
import business_layer.Restaurant;
import data_layer.RestaurantSerializator;
import presentation_layer.GuiA;
import presentation_layer.GuiC;
import presentation_layer.GuiU;
import presentation_layer.GuiW;

public class App {
	public static void main(String[] args) {

		GuiA a = new GuiA();
		GuiW w = new GuiW();
		GuiC c = new GuiC();
		GuiU u = new GuiU(a, w, c);
		/**
		 * RestaurantSerializator r = new RestaurantSerializator(); List<MenuItem>
		 * menu=new ArrayList<MenuItem>(); List<MenuItem> menu2=new
		 * ArrayList<MenuItem>();
		 * 
		 * MenuItem p1=new CompositeProduct ("Pizza Carbonara", 0); MenuItem p2=new
		 * CompositeProduct ("Pizza Margherita", 0); MenuItem p3=new CompositeProduct
		 * ("Pizza Prosciuto", 0); MenuItem p4=new CompositeProduct ("Pizza
		 * Vegetariana", 0); MenuItem p5=new CompositeProduct ("Pizza Canibale", 0);
		 * 
		 * 
		 * MenuItem c1=new CompositeProduct ("Paste Quatro Formagi", 0); MenuItem c2=new
		 * CompositeProduct ("Paste Alfredo", 0); MenuItem c3=new CompositeProduct
		 * ("Paste Carbonara", 0);
		 * 
		 * MenuItem c5=new CompositeProduct ("Salata Caesar", 0);
		 * 
		 * MenuItem c6=new CompositeProduct ("Omleta", 0);
		 * 
		 * MenuItem c7=new CompositeProduct ("Piept de Pui Grill", 12); MenuItem c8=new
		 * CompositeProduct ("Peste", 18);
		 * 
		 * MenuItem c9=new CompositeProduct ("Cartofi prajiti", 8); MenuItem c10=new
		 * CompositeProduct ("Cartofi piure", 7); MenuItem c11=new CompositeProduct
		 * ("Orez", 5); MenuItem c12=new CompositeProduct ("Broccoli", 9); MenuItem
		 * c13=new CompositeProduct ("Mamaliga", 7);
		 * 
		 * 
		 * MenuItem c14=new BaseProduct ("Apa plata", 4); MenuItem c19=new BaseProduct
		 * ("Apa Minerala", 4); MenuItem c15=new BaseProduct ("Cola", 5); MenuItem
		 * c16=new BaseProduct ("Sprite", 5); MenuItem c17=new BaseProduct ("Ceai", 4);
		 * MenuItem c18=new BaseProduct ("Cafea", 6);
		 * 
		 * 
		 * 
		 * MenuItem c21=new BaseProduct ("oua", 4); MenuItem c22=new BaseProduct
		 * ("sunca", 8); c6.addProduct(c21); c6.addProduct(c22); c6.computePrice(c6);
		 * 
		 * MenuItem c23=new BaseProduct ("salata verde", 4); MenuItem c24=new
		 * BaseProduct ("piept de pui", 6); MenuItem c25=new BaseProduct ("crutoane",
		 * 2); MenuItem c26=new BaseProduct ("sos", 2); c5.addProduct(c23);
		 * c5.addProduct(c24); c5.addProduct(c25); c5.addProduct(c26);
		 * c5.computePrice(c5);
		 * 
		 * MenuItem c27=new BaseProduct ("spaghetti", 5); MenuItem c28=new BaseProduct
		 * ("bacon", 6); MenuItem c29=new BaseProduct ("smantana", 5); MenuItem c30=new
		 * BaseProduct ("parmezan", 8); c3.addProduct(c27); c3.addProduct(c28);
		 * c3.addProduct(c29); c3.addProduct(c30); c3.computePrice(c3);
		 * 
		 * MenuItem c31=new BaseProduct ("penne", 6); MenuItem c32=new BaseProduct ("sos
		 * usturoi", 8); MenuItem c33=new BaseProduct ("pui", 12); c2.addProduct(c31);
		 * c2.addProduct(c32); c2.addProduct(c33); c2.computePrice(c2);
		 * 
		 * MenuItem c34=new BaseProduct ("branzeturi", 20); MenuItem c35=new BaseProduct
		 * ("penne", 6); c1.addProduct(c34); c1.addProduct(c35); c1.computePrice(c1);
		 * 
		 * MenuItem c36=new CompositeProduct ("blat", 5); MenuItem c37=new BaseProduct
		 * ("sos de rosii", 3); MenuItem c38=new BaseProduct ("kaiser", 8); MenuItem
		 * c39=new BaseProduct ("ou", 3); MenuItem c40=new BaseProduct ("smantana", 4);
		 * p1.addProduct(c36); p1.addProduct(c37); p1.addProduct(c38);
		 * p1.addProduct(c39); p1.addProduct(c40); p1.computePrice(p1);
		 * 
		 * MenuItem c41=new CompositeProduct ("blat", 5); MenuItem c42=new BaseProduct
		 * ("sos de rosii", 4); MenuItem c43=new BaseProduct ("branza", 12);
		 * p2.addProduct(c41); p2.addProduct(c42); p2.addProduct(c43);
		 * p2.computePrice(p2);
		 * 
		 * MenuItem c44=new CompositeProduct ("blat", 5); MenuItem c45=new BaseProduct
		 * ("sos", 3); MenuItem c46=new BaseProduct ("sunca", 7); MenuItem c47=new
		 * BaseProduct ("salam", 5); MenuItem c48=new BaseProduct ("carnati", 7);
		 * p5.addProduct(c44); p5.addProduct(c45); p5.addProduct(c46);
		 * p5.addProduct(c47); p5.addProduct(c48); p5.computePrice(p5);
		 * 
		 * MenuItem c49=new CompositeProduct ("blat", 5); MenuItem c50=new BaseProduct
		 * ("sos", 3); MenuItem c51=new BaseProduct ("sunca", 4); MenuItem c52=new
		 * BaseProduct ("ciuperci", 6); MenuItem c53=new BaseProduct ("branza", 8);
		 * p3.addProduct(c49); p3.addProduct(c50); p3.addProduct(c51);
		 * p3.addProduct(c52); p3.addProduct(c53); p3.computePrice(p3);
		 * 
		 * MenuItem c54=new CompositeProduct ("blat", 5); MenuItem c55=new BaseProduct
		 * ("sos", 4); MenuItem c56=new BaseProduct ("vinete", 5); MenuItem c57=new
		 * BaseProduct ("ardei", 4); MenuItem c58=new BaseProduct ("branza", 5);
		 * p4.addProduct(c54); p4.addProduct(c55); p4.addProduct(c56);
		 * p4.addProduct(c57); p4.addProduct(c58); p4.computePrice(p4);
		 * 
		 * MenuItem c60=new BaseProduct("Ketchup",4); MenuItem c61=new BaseProduct("sos
		 * de usturoi",4); MenuItem c62=new BaseProduct("salata verde",4); MenuItem
		 * c63=new BaseProduct("sunca",8);
		 * 
		 * menu.add(p1); menu.add(p2); menu.add(p3); menu.add(p4); menu.add(p5);
		 * menu.add(c1); menu.add(c2); menu.add(c3); menu.add(c5); menu.add(c6);
		 * menu.add(c7); menu.add(c8); menu.add(c9); menu.add(c10); menu.add(c11);
		 * menu.add(c12);
		 * 
		 * menu.add(c13); menu.add(c14); menu.add(c19); menu.add(c15); menu.add(c16);
		 * menu.add(c17); menu.add(c18); menu.add(c60); menu.add(c61); menu.add(c62);
		 * menu.add(c63);
		 * 
		 * r.serialize(menu);
		 */
		Restaurant restaurant = new Restaurant(u);

	}
}
