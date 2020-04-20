package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.ConnectionFactory;
import model.Product;

public class ProductDAO extends AbstractDAO<Product> {

	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private final static String findStatementString = "SELECT * FROM product where id_p =  ?";
	private final static String update = "update product set nr_produse=? where id_p=?";

	public static Product findSpecificProduct(int productId) {
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, productId);
			rs = findStatement.executeQuery();
			rs.next();
			int id_p = rs.getInt("id_p");
			String den = rs.getString("denumire");
			String marca = rs.getString("marca");
			int pret = rs.getInt("pret");
			int nrp = rs.getInt("nr_produse");
			toReturn = new Product(id_p, den, marca, pret, nrp);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

	public void udc(int c, int idp) {
		Connection dbConnection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStmt = dbConnection.prepareStatement(update);
			preparedStmt.setInt(1, c);
			preparedStmt.setInt(2, idp);

			preparedStmt.executeUpdate();

			dbConnection.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

	public void updatePrice(int c, int idp) {
		String update = "update product set pret=? where id_p=?";
		Connection dbConnection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStmt = dbConnection.prepareStatement(update);
			preparedStmt.setInt(1, c);
			preparedStmt.setInt(2, idp);

			preparedStmt.executeUpdate();

			dbConnection.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
}
