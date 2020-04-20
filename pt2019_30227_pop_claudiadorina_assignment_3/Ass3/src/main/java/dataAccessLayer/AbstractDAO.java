package dataAccessLayer;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import connection.ConnectionFactory;

public abstract class AbstractDAO<T> extends JFrame {
	public static Vector<Integer> a = new Vector<Integer>();
	public static Vector<Integer> b = new Vector<Integer>();

	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());
	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}

	private String insertString() {
		String insertStatementString = "INSERT INTO " + type.getSimpleName() + " values (?,?,?,?,?)";
		return insertStatementString;
	}

	private String insertStringO() {
		String insertStatementString = "INSERT INTO " + type.getSimpleName() + " values (?,?,?)";
		return insertStatementString;
	}

	public int insert(T instance) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		try {
			if (type.getSimpleName().equals("Orders"))
				insertStatement = dbConnection.prepareStatement(insertStringO(), Statement.RETURN_GENERATED_KEYS);

			else
				insertStatement = dbConnection.prepareStatement(insertString(), Statement.RETURN_GENERATED_KEYS);
			int i = 0;
			for (Field field : instance.getClass().getDeclaredFields()) {
				i++;
				field.setAccessible(true);
				insertStatement.setObject(i, field.get(instance));

			}
			insertStatement.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Duplicate primary key!");
			LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return 1;
	}

	public List<T> findAll() {
		if (type.getSimpleName().equals("Client"))
			a.clear();
		else if (type.getSimpleName().equals("Product"))
			b.clear();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {

			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement("select * from " + type.getSimpleName());
			resultSet = statement.executeQuery();
			createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findall " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String c = type.getSimpleName().toString().toLowerCase().charAt(0) + "\n";
		String query = createSelectQuery("id_" + c);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	List<T> list = new ArrayList<T>();

	private List<T> createObjects(ResultSet resultSet) {

		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					field.setAccessible(true);
					Object value = resultSet.getObject(field.getName());
					field.set(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public DefaultTableModel retrieveProperties() {

		Vector<String> header = new Vector<String>();
		Vector<Vector<Object>> content = new Vector<Vector<Object>>();
		T obj = list.get(0);
		for (Field field : obj.getClass().getDeclaredFields()) {
			header.add(field.getName());
		}
		for (Object object : list) {
			Vector<Object> vector = new Vector<Object>();
			for (Field field : object.getClass().getDeclaredFields()) {
				field.setAccessible(true); // set modifier to public
				Object value;
				try {
					value = field.get(object);
					vector.add(value);

					if (field.getName() == "id_c" && type.getSimpleName().equals("Client")) {
						a.add((Integer) value);
					}
					if (field.getName() == "id_p" && type.getSimpleName().equals("Product")) {
						b.add((Integer) value);
					}

				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
			content.add(vector);
		}

		return new DefaultTableModel(content, header);
	}

	public Vector<Integer> idc() {
		return a;
	}

	public Vector<Integer> idp() {
		return b;
	}

	public void deleteFromTable(int id) {
		String delete = "delete from " + type.getSimpleName() + " where id_"
				+ type.getSimpleName().toString().toLowerCase().charAt(0) + "=?";
		Connection dbConnection = ConnectionFactory.getConnection();
		try {
			PreparedStatement preparedStmt = dbConnection.prepareStatement(delete);
			preparedStmt.setInt(1, id);
			preparedStmt.executeUpdate();
			dbConnection.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}

}
