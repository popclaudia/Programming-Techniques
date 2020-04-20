package businessLayer;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import dataAccessLayer.ProductDAO;
import model.Product;

public class ProductBL {
	

	public ProductBL() {
	}
	
    ProductDAO p=new ProductDAO();
	
	
	public DefaultTableModel findAll() {
		p.findAll();
		return p.retrieveProperties();
	
	}
	public Vector<Integer> idp() {
		return p.idp();
	}
	public int insertProduct(Product pp) {
		
		return p.insert(pp);
	}

	public Product ordp(int productId) {
		return p.findSpecificProduct(productId);
	}
	public void  updatec(int c,int idp) {
		p.udc(c,idp);
	}
	public void  updateprice(int c, int idp) {
		p.updatePrice(c,idp);
	}
	public void  del(int c) {
		p.deleteFromTable(c);
	}

}
