package businessLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import businessLayer.validate.EmailValidator;
import businessLayer.validate.Validator;
import dataAccessLayer.ClientDAO;
import model.Client;

public class ClientBL {
	private List<Validator<Client>> validators;

	public ClientBL() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
	}

	ClientDAO c = new ClientDAO();

	public Client findClientById(int id) {
		Client st = c.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}

	public DefaultTableModel findAll() {
		c.findAll();
		return c.retrieveProperties();

	}

	public Vector<Integer> idc() {
		return c.idc();
	}

	public int insertClient(Client client) {
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		return c.insert(client);
	}

	public Client ordc(int clId) {
		return c.findSpecificClient(clId);
	}

	public void del(int cc) {
		c.deleteFromTable(cc);
	}

	public void updateadr(int cc, String idp) {
		c.updateAddr(cc, idp);
	}
}
