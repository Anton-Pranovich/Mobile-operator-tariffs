package by.itstep.pronovich.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.itstep.pronovich.exception.AddException;
import by.itstep.pronovich.exception.DaoSQLException;
import by.itstep.pronovich.model.Tariff;

public class ProductDao {

	private static final Logger log = LoggerFactory.getLogger(ProductDao.class);

	public static List<Tariff> showProduct() throws SQLException {
		Connection connection = ConnectionUrl.getConnection();
		Statement statement = connection.createStatement();
		List<Tariff> tariffCatalog = new ArrayList<>();
		ResultSet result = statement.executeQuery("SELECT * FROM tariffs");
		while (result.next()) {
			long id = Long.parseLong(result.getString(1));
			String name = result.getString(2);
			String operator = result.getString(3);
			double subscriptionFee = Double.parseDouble(result.getString(4));
			String description = result.getString(5);

			tariffCatalog.add(new Tariff(id, name, operator, subscriptionFee, description));
		}
		log.info("show products");
		return tariffCatalog;
	}

	public static void createTable() throws ClassNotFoundException, SQLException, DaoSQLException {
		Connection connection = null;
		try {
			// getting a database connection
			connection = ConnectionUrl.getConnection();

			System.out.println(connection.getMetaData().getURL());

			Statement statement = connection.createStatement();

			// executing a query that creates a user table
			boolean createTable = statement.execute("CREATE TABLE if not exists " + "tariffs (id BIGINT PRIMARY KEY "
					+ "AUTO_INCREMENT, name VARCHAR(100), " + "operator VARCHAR(100), "
					+ "subscriptionFee DECIMAL(15,2)," + " description TEXT);");
			if (createTable) {
				log.info("Table users created");
			}
		} catch (SQLException e) {
			log.error("Can't create table", e);
			throw new DaoSQLException("Can't create table", e);
		}
	}

	public static boolean addProduct(String name, String operator, String subscriptionFee, String description)
			throws SQLException, AddException {
		boolean answer = false;
		Connection connection = ConnectionUrl.getConnection();
		Statement statement = connection.createStatement();
		String[] data = { name, operator, subscriptionFee, description };
		if (!name.isEmpty() && !operator.isEmpty() && !subscriptionFee.isEmpty() && !description.isEmpty()) {
			String query = String.format(
					"INSERT INTO tariffs (name, operator, subscriptionFee, description ) VALUES ('%s', '%s', '%s', '%s')",
					data[0], data[1], data[2], data[3]);
			System.out.println(query);
			statement.execute(query);
			answer = true;
			log.info("product has been added ");
		} else {
			log.error("throw addException ");
			throw new AddException();
		}
		return answer;
	}

//	public static boolean findProduct(String id) throws SQLException, FindProductException {
//		boolean answer = false;
//		int findId = Integer.parseInt(id);
//		Connection connection = ConnectionUrl.getConnection();
//		String find = String.format("SELECT name FROM goods WHERE id = " + findId);
//		Statement statement = connection.prepareStatement(find);
//		ResultSet rs = statement.executeQuery(find);
//		if (rs.next()) {
//			log.info("product has been found.");
//			answer = true;
//		} else {
//			log.error("product not found.");
//			throw new FindProductException();
//		}
//		return answer;
//	}
}
