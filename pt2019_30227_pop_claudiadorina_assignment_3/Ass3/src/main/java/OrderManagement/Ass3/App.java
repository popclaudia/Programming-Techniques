package OrderManagement.Ass3;

import connection.ConnectionFactory;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
	import java.util.logging.Logger;

	import businessLayer.ClientBL;
import businessLayer.ProductBL;
import model.Client;
import model.Product;
import presentation.Controller;
import presentation.Gui;

public class App 
{
		protected static final Logger LOGGER = Logger.getLogger(App.class.getName());

		public static void main(String[] args) throws SQLException {

			Gui g=new Gui();
			
			ClientBL c = new ClientBL();	
			c.findAll();
			Vector<Integer>v1=new Vector<Integer>();
			v1=c.idc();
			
			ProductBL p = new ProductBL();
			p.findAll();
			Vector<Integer>v2=new Vector<Integer>();
			v2=p.idp();			
			g.combo(v1, v2);
			Controller controller=new Controller(g);
		}
		
}
