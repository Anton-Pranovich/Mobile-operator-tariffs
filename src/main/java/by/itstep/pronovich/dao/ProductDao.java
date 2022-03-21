package by.itstep.pronovich.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	private static final String SQL_DELETE_TARIFF_QUERY = "DELETE FROM tariffs WHERE id = ?";
	private static final String SQL_UPDATE_TARIFF_QUERY = "UPDATE tariffs SET name = ?, operator = ?, subscriptionFee=?, call_cost=?, sms_cost=?, number_of_megabytes=?, description=? WHERE id = ?";
	private static final String SQL_ADD_TARIFF_QUERY = "INSERT INTO tariffs (name, operator, subscriptionFee, call_cost, sms_cost, number_of_megabytes, description ) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
	private static final String SQL_FIND_TARIFF_LIKE_QUERY = "SELECT * FROM tariffs WHERE name LIKE ?";
	private static final String SQL_SELECT_ALL_TARIFF_QUERY = "SELECT * FROM tariffs";

	private static final Logger log = LoggerFactory.getLogger(ProductDao.class);

	public static List<Tariff> showProduct() throws SQLException {
		Connection connection = ConnectionUrl.getConnection();
		Statement statement = connection.createStatement();
		List<Tariff> tariffCatalog = new ArrayList<>();
		ResultSet result = statement.executeQuery(SQL_SELECT_ALL_TARIFF_QUERY);
		while (result.next()) {
			long id = Long.parseLong(result.getString(1));
			String name = result.getString(2);
			String operator = result.getString(3);
			double subscriptionFee = Double.parseDouble(result.getString(4));
			String description = result.getString(8);
			double callCost = Double.parseDouble(result.getString(5));
			double smsCost = Double.parseDouble(result.getString(6));
			double numberOfMegabytes = Double.parseDouble(result.getString(7));
			tariffCatalog.add(
					new Tariff(id, name, operator, subscriptionFee, description, callCost, smsCost, numberOfMegabytes));
		}
		log.info("show products");
		return tariffCatalog;
	}

	public static boolean addProduct(String name, String operator, String subscriptionFee, String description,
			String callCost, String smsCost, String numberOfMegabytes) throws SQLException, AddException {
		boolean answer = false;
		Connection connection = ConnectionUrl.getConnection();
		Statement statement = connection.createStatement();
		String[] data = { name, operator, subscriptionFee, callCost, smsCost, numberOfMegabytes, description };
		if (!name.isEmpty() && !operator.isEmpty() && !subscriptionFee.isEmpty() && !description.isEmpty()) {
			String query = String.format(SQL_ADD_TARIFF_QUERY, data[0], data[1], data[2], data[3], data[4], data[5],
					data[6]);
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

	/**
	 * Edit tariff method
	 * @throws SQLException 
	 */
	public static void update(Tariff tariff) throws DaoSQLException, SQLException {
		
		try (Connection connection = ConnectionUrl.getConnection()) {
			PreparedStatement statement;
			statement = connection.prepareStatement(SQL_UPDATE_TARIFF_QUERY);
			System.out.println(tariff.getName());
			statement.setString(1, tariff.getName());
			statement.setString(2, tariff.getOperator());
			statement.setDouble(3, tariff.getSubscriptionFee());
			statement.setDouble(4, tariff.getCallCost());
			statement.setDouble(5, tariff.getSmsCost());
			statement.setDouble(6, tariff.getNumberOfMegabytes());
			statement.setString(7, tariff.getDescription());
			statement.setLong(8, tariff.getId());
			
			statement.executeUpdate();
			statement.close();
			log.info("product has been updated ");
		} catch (SQLException | DaoSQLException | NullPointerException e) {
			log.info("product has problems in updating ");
			throw new DaoSQLException("Error in updating product by name dao method " + e.getMessage(), e);
		}
	}

	/**
	 * Delete tariff method by id
	 */
	public static void delete(Long id) throws DaoSQLException {

		try (Connection connection = ConnectionUrl.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_DELETE_TARIFF_QUERY);) {
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException | DaoSQLException e) {
			throw new DaoSQLException("Error in deleting product by name dao method " + e.getMessage(), e);
		}
	}

	/**
	 * Метод поиска товара по названию
	 */
	public List<Tariff> findByName(String newName) throws DaoSQLException {
		List<Tariff> list = new ArrayList<>();
		try (Connection connection = ConnectionUrl.getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_FIND_TARIFF_LIKE_QUERY);) {
			statement.setString(1, "%" + newName + "%");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				list.add(new Tariff(id, name, name, price, name, price, price, price));
			}
		} catch (SQLException | DaoSQLException e) {
			throw new DaoSQLException("Error in finding by name dao method " + e.getMessage(), e);
		}
		return list;

	}
}
