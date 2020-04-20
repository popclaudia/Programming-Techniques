package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;

public class ClientDAO extends AbstractDAO<Client> {

	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private final static String findStatementString = "SELECT * FROM client where id_c =  ?";

	public static Client findSpecificClient(int clientId) {
		Client toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, clientId);
			rs = findStatement.executeQuery();
			rs.next();
			int id_c = rs.getInt("id_c");
			String name = rs.getString("name");
			String a = rs.getString("address");
			String phone = rs.getString("phone");
			String e_mail = rs.getString("e_mail");
			toReturn = new Client(id_c, name, a, phone, e_mail);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

	public void updateAddr(int c, String ad) {
		String update = "update client set address=? where id_c=?";
		Connection dbConnection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStmt = dbConnection.prepareStatement(update);
			preparedStmt.setString(1, ad);
			preparedStmt.setInt(2, c);

			preparedStmt.executeUpdate();

			dbConnection.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

}
