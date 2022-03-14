package by.itstep.pronovich.controller;

import java.sql.SQLException;

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
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/editTariff")
	public String editTariff() {
		return "editTariff";
	}
	
	@GetMapping("/adminStart")
	public String adminStart() {
		return "adminStart";
	}
	
	@PostMapping("/addTariff")
	public String addProduct(@ModelAttribute @Valid Tariff tariff, BindingResult bindingResult, Model model)
			throws SQLException {
		//String answer;
		if (bindingResult.hasErrors()) {
			log.info("Returning addProduct.jsp page");
		//	answer = "Invalid input data";
		//	model.addAttribute("answer", answer);
			return "addTariff";
		}
		
		String name = tariff.getName();
		String operator = tariff.getOperator();
		String subscriptionFee = Double.toString(tariff.getSubscriptionFee());
		String description = tariff.getDescription();

		model.addAttribute("path", "/addTariff");
		try {
			try {
				ProductDao.addProduct(name, operator,subscriptionFee,description);
		//		answer = "Product has been added";
				log.info("Product has been added");
			} catch (AddException e) {
			//	answer = "throw AddException";
				log.error("Product adding exception", e);
			}
		//	model.addAttribute("answer", answer);
		} catch (DaoSQLException e) {
			log.error("SQLException", e);
		}
		return "addTariff";
	}
}
