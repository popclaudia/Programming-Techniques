package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import businessLayer.ClientBL;
import businessLayer.OrderBL;
import businessLayer.ProductBL;
import model.Client;
import model.Orders;
import model.Product;

public class Controller {
	Gui g;
	int idc, idp, pret, nrp, cant;
	String name, addr, phone, mail, den, marca;

	public Controller(Gui g) {
		this.g = g;
		this.g.list1Listener(new List1Listener());
		this.g.list2Listener(new List2Listener());
		this.g.del1Listener(new Del1Listener());
		this.g.del2Listener(new Del2Listener());
		this.g.ins1Listener(new Ins1Listener());
		this.g.ins2Listener(new Ins2Listener());
		this.g.ed1Listener(new Ed1Listener());
		this.g.ed2Listener(new Ed2Listener());
		this.g.orderListener(new OrderListener());
	}

	class List1Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {

			ClientBL cb = new ClientBL();
			g.table1(cb.findAll());

		}
	}

	class List2Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			ProductBL cb = new ProductBL();
			g.table2(cb.findAll());
		}
	}

	class Del1Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			idc = Integer.parseInt(g.getidc());

			ClientBL pb = new ClientBL();
			pb.del(idc);
			g.table1(pb.findAll());

		}
	}

	class Del2Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			idp = Integer.parseInt(g.getidp());

			ProductBL pb = new ProductBL();
			pb.del(idp);
			g.table2(pb.findAll());
		}
	}

	class Ins1Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			idc = Integer.parseInt(g.getidc());
			name = g.getname();
			addr = g.getaddr();
			phone = g.getphone();
			mail = g.getmail();

			Client c = new Client(idc, name, addr, phone, mail);
			ClientBL cb = new ClientBL();
			cb.insertClient(c);

		}

	}

	class Ins2Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			idp = Integer.parseInt(g.getidp());
			den = g.getden();
			marca = g.getmarca();
			pret = Integer.parseInt(g.getpret());
			nrp = Integer.parseInt(g.getnrp());

			Product p = new Product(idp, den, marca, pret, nrp);
			ProductBL pb = new ProductBL();
			pb.insertProduct(p);

		}

	}

	class Ed1Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			idc = Integer.parseInt(g.getidc());
			addr = g.getaddr();

			ClientBL pb = new ClientBL();
			pb.updateadr(idc,addr);
			g.table1(pb.findAll());
		}

	}

	class Ed2Listener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			idp = Integer.parseInt(g.getidp());
			pret = Integer.parseInt(g.getpret());

			ProductBL pb = new ProductBL();
			pb.updateprice(pret,idp);
			g.table2(pb.findAll());
		}

	}

	class OrderListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			OrderBL cb = new OrderBL();
			ClientBL c = new ClientBL();
			ProductBL p = new ProductBL();

			idc = g.getco();
			idp = g.getcp();
			cant = Integer.parseInt(g.getcant());
			/*
			 * c.findAll(); Vector<Integer>v1=new Vector<Integer>(); v1=c.idc();
			 * p.findAll(); Vector<Integer>v2=new Vector<Integer>(); v2=p.idp(); g.combo(v1,
			 * v2);
			 */

			Orders o = new Orders(idc, idp, cant);

			Client cl = new Client();
			cl = c.ordc(idc);
			Product pr = new Product();
			pr = p.ordp(idp);
			if (cant > pr.getNr_produse())
				g.understock(pr.getNr_produse());
			else {
				cb.insertOrder(o);
				g.table3(cb.findAll());
				p.updatec((pr.getNr_produse() - cant), idp);
				try {
					File file = new File("MyBill" + idc + "" + idp + ".txt");
					file.createNewFile();
					FileWriter f = new FileWriter(file, true);
					f.write("Bill number:" + idc + "." + idp + "\n                      ");
					f.append("Client code: " + idc + "\n                                     ");
					f.append("Client name: " + cl.getName() + "\n                            ");
					f.write("Product code: " + idp + "\n                                      ");
					f.write("Product: " + pr.getDenumire() + "\n                             ");
					f.write("Number of products: " + cant + "\n                              ");
					f.write("Price/Product: " + pr.getPret() + "\n                           ");
					f.write("Price to pay: " + cant * pr.getPret() + " lei.\n                ");
					f.flush();
					f.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}
	}
}
