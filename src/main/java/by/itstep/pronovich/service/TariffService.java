package by.itstep.pronovich.service;

import java.util.List;

import by.itstep.pronovich.exception.ServiceException;
import by.itstep.pronovich.model.Tariff;

public interface TariffService {
	public List<Tariff> loadFindTariffByName(String name) throws ServiceException;
	//public List<Tariff> loadAll() throws ServiceException;
}
