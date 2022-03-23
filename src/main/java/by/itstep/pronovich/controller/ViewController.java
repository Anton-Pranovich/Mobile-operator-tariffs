package by.itstep.pronovich.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import by.itstep.pronovich.dao.impl.TariffDaoImpl;
import by.itstep.pronovich.model.Tariff;

@Controller
public class ViewController {
	@Autowired
	private TariffDaoImpl dao;
	private List<Tariff> tariffCatalog;
	private static final Logger log = LoggerFactory.getLogger(ViewController.class);

	@GetMapping("catalog")
	public String show(Model model) {
		try {
			tariffCatalog = dao.showTariff();
			model.addAttribute("list", tariffCatalog);
			log.info("Show all tariffs");
		} catch (SQLException e) {
			log.error("SQLException", e);
		}
		model.addAttribute("tariffCatalog", tariffCatalog);
		return "catalog";
	}

	@GetMapping("user/{id}")
	public String tariffPage(@ModelAttribute Tariff tariff) {
		log.info("Show personal tariff page for user");
		return "tariff";
	}

	@GetMapping("/{id}")
	public String catalogPage(@ModelAttribute Tariff tariff) {
		log.info("Show personal tariff page");
		return "tariff";
	}
}
