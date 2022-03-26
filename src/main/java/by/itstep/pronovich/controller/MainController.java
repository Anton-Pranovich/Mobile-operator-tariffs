package by.itstep.pronovich.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.itstep.pronovich.dao.impl.TariffDaoImpl;
import by.itstep.pronovich.exception.DaoSQLException;
import by.itstep.pronovich.model.Tariff;
import by.itstep.pronovich.service.impl.TariffServiceImpl;

@Controller
public class MainController {
	@Autowired
	private TariffServiceImpl service;
	@Autowired
	private TariffDaoImpl dao;
	private List<Tariff> tariffCatalog = new ArrayList<>();
	private String message;

	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@RequestMapping(value = { "/user/addTariff" })
	public String staticResource(Model model) {
		model.addAttribute("tariff", new Tariff());
		log.info("tarif has been added ");
		return "addTariff";
	}

	@RequestMapping(value = "/user/tariff/delete")
	public String deleteProduct(@ModelAttribute Tariff tariff, Model model) {
		try {
			dao.delete(tariff.getId());
			log.info("product has been deleted ");

		} catch (DaoSQLException e) {
			model.addAttribute("message_action", "An error occurred while deleting the product.");
			log.error("tariff not deleted. Throw DaoSqlException ", e);
			return "redirect:/catalog";
		}
		return "redirect:/user/catalog";
	}

	@RequestMapping(value = "user/updateTariff/{id}")
	public String refUpdateProductPage(@ModelAttribute Tariff tariff) { // @ModelAttribute save tariff's data in Tariff
																		// tariff
		log.info("update tariff page ");
		return "update"; // return catalog page
	}

	@RequestMapping(value = "/search")
	public String searchProduct(@RequestParam(defaultValue = "") String search_tariff,
			@RequestParam(value = "message_action", defaultValue = "View all tariffs catalog") String message_act,
			Model model) throws SQLException {
		if (!search_tariff.isEmpty()) {
			tariffCatalog = service.loadFindTariffByName(search_tariff);
			log.info("search parameters aren't empty ");
		} else {
			tariffCatalog = dao.showTariff();
			model.addAttribute("list", tariffCatalog);
			log.info("search parameters are empty. Show all tarifs ");
		}
		message = "Found " + tariffCatalog.size() + " tariff(s)";
		model.addAttribute("tariffCatalog", tariffCatalog);
		model.addAttribute("message", message);

		return "catalog";
	}

	@RequestMapping(value = "/user/search")
	public String searchTariff(@RequestParam(defaultValue = "") String search_tariff,
			@RequestParam(value = "message_action", defaultValue = "View all tariffs catalog") String message_act,
			Model model) throws SQLException {
		if (!search_tariff.isEmpty()) {
			tariffCatalog = service.loadFindTariffByName(search_tariff);
			model.addAttribute("list", tariffCatalog);
			log.info("search parameters aren't empty ");
		} else {
			tariffCatalog = dao.showTariff();
			model.addAttribute("list", tariffCatalog);
			log.info("search parameters are empty. Show all tarifs ");
		}
		message = "Found " + tariffCatalog.size() + " tariff(s)";
		model.addAttribute("tariffCatalog", tariffCatalog);
		return "adminCatalog";
	}
}