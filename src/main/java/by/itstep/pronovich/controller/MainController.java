package by.itstep.pronovich.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.itstep.pronovich.dao.impl.TariffDaoImpl;
import by.itstep.pronovich.exception.AddException;
import by.itstep.pronovich.exception.DaoSQLException;
import by.itstep.pronovich.model.Order;
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

	@RequestMapping(value = { "/admin/addTariff" })
	public String staticResource(Model model) {
		model.addAttribute("tariff", new Tariff());
		log.info("tarif has been added ");
		return "addTariff";
	}

	@RequestMapping(value = "/admin/tariff/delete")
	public String deleteProduct(@ModelAttribute Tariff tariff, Model model) {
		try {
			dao.delete(tariff.getId());
			log.info("product has been deleted ");

		} catch (DaoSQLException e) {
			model.addAttribute("message_action", "An error occurred while deleting the product.");
			log.error("tariff not deleted. Throw DaoSqlException ", e);
			return "redirect:/catalog";
		}
		return "redirect:/admin/catalog";
	}

	@RequestMapping(value = "admin/updateTariff/{id}")
	public String refUpdateTariffPage(@ModelAttribute Tariff tariff) { // @ModelAttribute save tariff's data in Tariff
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

	@RequestMapping(value = "/admin/search")
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
		return "catalog";
	}
	@RequestMapping(value = "orderTariff/{id}")
	public String orderTariffPage(@ModelAttribute Order order) { // @ModelAttribute save tariff's data in Tariff
																		// tariff
		log.info("order tariff page ");
		return "orderTariff"; 
	}
	@RequestMapping(value = "admin/orderTariff/{id}")
	public String adminOrderTariffPage(@ModelAttribute Order order) { // @ModelAttribute save tariff's data in Tariff
																		// tariff
		log.info("order tariff page ");
		return "orderTariff"; 
	}
	
	@PostMapping("/orderTariff")
	public String addProduct(@ModelAttribute @Valid Order order, BindingResult bindingResult, Model model, Tariff tariff)
			throws SQLException {
		if (bindingResult.hasErrors()) {
			log.info("Returning addTariff.jsp page");
			return "orderTariff";
		}

		String name = tariff.getName();
		String operator = tariff.getOperator();
		String firstName = order.getFirstName();
		String lastName = order.getLastName();
		String phoneNumber = order.getPhoneNumber();
		
		model.addAttribute("path", "/orderTariff");
		try {
			try {
				dao.addTariffOrder(name, operator, firstName, lastName, phoneNumber);
				log.info("Tariff has been added");
			} catch (AddException e) {
				log.error("Tariff adding exception", e);
			}
		} catch (DaoSQLException e) {
			log.error("SQLException", e);
		}
		return "redirect:/catalog";
	}
}