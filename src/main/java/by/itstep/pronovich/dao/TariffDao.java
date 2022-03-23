package by.itstep.pronovich.dao;

import java.sql.SQLException;
import java.util.List;

import by.itstep.pronovich.exception.AddException;
import by.itstep.pronovich.exception.DaoSQLException;
import by.itstep.pronovich.model.Tariff;

public interface TariffDao {
	public List<Tariff> showTariff() throws SQLException;

	public void addProduct(String name, String operator, String subscriptionFee, String description, String callCost,
			String smsCost, String numberOfMegabytes) throws SQLException, AddException;

	public void update(Tariff tariff) throws DaoSQLException, SQLException;

	public void delete(Long id) throws DaoSQLException;
}
