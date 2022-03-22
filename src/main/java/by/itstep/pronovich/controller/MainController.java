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

import by.itstep.pronovich.dao.ProductDao;
import by.itstep.pronovich.exception.DaoSQLException;
import by.itstep.pronovich.model.Tariff;
import by.itstep.pronovich.service.impl.TariffServiceImpl;

@Controller
public class MainController {
	@Autowired
	public TariffServiceImpl service;
	private List<Tariff> tariffCatalog = new ArrayList<>();
	private String message;
	private String message_action;
	
	private static final Logger log = LoggerFactory.getLogger(ProductDao.class);
	@RequestMapping(value = { "/user/addTariff" })
	public String staticResource(Model model) {
		model.addAttribute("tariff", new Tariff());
		return "addTariff";
	}

	@RequestMapping(value = "/user/tariff/delete")
	public String deleteProduct(@ModelAttribute Tariff tariff, Model model) {
		try {
			ProductDao.delete(tariff.getId());
		} catch (DaoSQLException e) {
			model.addAttribute("message_action", "An error occurred while deleting the product.");
			return "redirect:/catalog";
		}
		return "redirect:/user/catalog";
	}

	@RequestMapping(value = "user/updateTariff/{id}")
	public String refUpdateProductPage(@ModelAttribute Tariff tariff) {// эта аннотация автоматически запишет в Model
																		// объект product и передаст дальше
		return "update"; // на этой странице мы можем получить данные о переданном объекте
	}
	
	@RequestMapping(value = "/search")
	public String searchProduct(@RequestParam (defaultValue = "") String search_tariff, @RequestParam(value = "message_action", defaultValue = "View all tariffs catalog")String message_act, Model model) throws SQLException {
		System.out.println(search_tariff+"main controller");
			if (!search_tariff.isEmpty()) {
				tariffCatalog = service.loadFindTariffByName(search_tariff);
				message_action = (tariffCatalog.isEmpty()) ? "Not found anything" : "Successfully searched";
				model.addAttribute("list", tariffCatalog);
			} else {
				tariffCatalog = ProductDao.showTariff();
				message_action = message_act;
				model.addAttribute("list", tariffCatalog);
			}
			message = "Found " + tariffCatalog.size() + " tariff(s)";
			model.addAttribute("tariffCatalog", tariffCatalog);
			model.addAttribute("message", message);
			model.addAttribute("message_action", message_action);

		return "adminCatalog";
	}
}