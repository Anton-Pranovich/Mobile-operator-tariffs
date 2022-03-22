package by.itstep.pronovich.controller;

import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import by.itstep.pronovich.dao.ProductDao;
import by.itstep.pronovich.exception.AddException;
import by.itstep.pronovich.exception.DaoSQLException;
import by.itstep.pronovich.model.Tariff;

@Controller
public class AdminController {
	private List<Tariff> tariffCatalog;
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);


	@GetMapping("/login")
	public String admin() {
		return "login";
	}

	@GetMapping("/user/editTariff")
	public String editTariff() {
		return "editTariff";
	}

	@GetMapping("user/catalog")
	public String show(Model model) {
		try {
			tariffCatalog = ProductDao.showTariff();
			model.addAttribute("list", tariffCatalog);
		} catch (SQLException e) {
			log.error("SQLException", e);
		}
		model.addAttribute("tariffCatalog", tariffCatalog);
		return "adminCatalog";
	}
	
	@GetMapping("/user/start")
	public String adminStartSecurity() {
		return "adminStart";
	}

	@PostMapping("/user/addTariff")
	public String addProduct(@ModelAttribute @Valid Tariff tariff, BindingResult bindingResult, Model model)
			throws SQLException {
		if (bindingResult.hasErrors()) {
			log.info("Returning addTariff.jsp page");
			return "addTariff";
		}
		String name = tariff.getName();
		String operator = tariff.getOperator();
		String subscriptionFee = Double.toString(tariff.getSubscriptionFee());
		String callCost = Double.toString(tariff.getCallCost());
		String smsCost = Double.toString(tariff.getSmsCost());
		String numberOfMegabytes = Double.toString(tariff.getNumberOfMegabytes());
		String description = tariff.getDescription();

		model.addAttribute("path", "/addTariff");
		try {
			try {
				ProductDao.addProduct(name, operator, subscriptionFee, description, callCost, smsCost,
						numberOfMegabytes);
				log.info("Tariff has been added");
			} catch (AddException e) {
				log.error("Tariff adding exception", e);
			}
		} catch (DaoSQLException e) {
			log.error("SQLException", e);
		}
		return "addTariff";
	}
	@PostMapping(value = "user/update/{id}")
	public String updateProduct(@ModelAttribute @Valid Tariff tariff, BindingResult bindingResult, Model model) throws SQLException {// здесь мы уже принимаем данные из формы
		if (bindingResult.hasErrors()) {
			log.info("Returning UpdateTariff.jsp page");
			return "update";
		}																// изменения объекта
		try {
			ProductDao.update(tariff);
		} catch (DaoSQLException e) {
			model.addAttribute("message_action", "Problems with changing product.");
			log.info("tariff hasn't update ");
			return "redirect:/user/catalog";
		}
		return "redirect:/user/catalog";
	}

}
