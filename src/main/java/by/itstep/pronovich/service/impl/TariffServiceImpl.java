package by.itstep.pronovich.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itstep.pronovich.dao.impl.TariffDaoImpl;
import by.itstep.pronovich.exception.DaoSQLException;
import by.itstep.pronovich.exception.ServiceException;
import by.itstep.pronovich.model.Tariff;
import by.itstep.pronovich.service.TariffService;

@Service
public class TariffServiceImpl implements TariffService {
	@Autowired
	TariffDaoImpl dao;

	/*
	 * Search tariffs method by name
	 */
	public List<Tariff> loadFindTariffByName(String name) throws ServiceException {
		List<Tariff> products = new ArrayList<>();
		try {
			products = dao.findByName(name);
		} catch (DaoSQLException e) {
			throw new ServiceException(
					"Problems with serching product by name from DB service method " + e.getMessage(), e);
		}
		return products;
	}
}
