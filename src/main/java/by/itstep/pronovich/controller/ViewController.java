package by.itstep.pronovich.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import by.itstep.pronovich.dao.ProductDao;
import by.itstep.pronovich.model.Tariff;

@Controller
public class ViewController {
	private List<Tariff> tariffCatalog;
	private static final Logger log = LoggerFactory.getLogger(ViewController.class);

	@GetMapping("/catalog")
	public String show(Model model) {
		try {
			tariffCatalog = ProductDao.showProduct();
			model.addAttribute("list", tariffCatalog);
		} catch (SQLException e) {
			log.error("SQLException", e);
		}
		model.addAttribute("tariffCatalog", tariffCatalog);
		return "catalog";
	}

	@GetMapping("/{id}")
	public String studentPage(@ModelAttribute Tariff tariff) {

		System.out.println(
				tariff.getName() + tariff.getOperator() + tariff.getSubscriptionFee() + tariff.getDescription());
		return "tariff";
	}
}
