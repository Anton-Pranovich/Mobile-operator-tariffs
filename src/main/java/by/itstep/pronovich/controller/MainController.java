package by.itstep.pronovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import by.itstep.pronovich.dao.ProductDao;
import by.itstep.pronovich.exception.DaoSQLException;
import by.itstep.pronovich.model.Tariff;

@Controller
public class MainController {

	@RequestMapping(value = { "/user/addTariff" })
	public String staticResource(Model model) {
		model.addAttribute("tariff", new Tariff());
		return "addTariff";
	}

	@RequestMapping(value = "/user/tariff/delete")
	public String deleteProduct(@ModelAttribute Tariff tariff, Model model) {
		try {
			ProductDao.delete(tariff.getId());
			// message_action = "Successfully deleted";
			// model.addAttribute("message_action", message_action);
		} catch (DaoSQLException e) {
			model.addAttribute("message_action", "An error occurred while deleting the product.");
			return "redirect:/catalog";
		}
		// model.addAttribute("message_action", message_action);
		return "redirect:/user/catalog";
	}

	@RequestMapping(value = "/user/updateTariff/{id}")
	public String refUpdateProductPage(@ModelAttribute Tariff tariff) {// эта аннотация автоматически запишет в Model
																		// объект product и передаст дальше
		return "update"; // на этой странице мы можем получить данные о переданном объекте
	}

	@GetMapping(value = "/user/{id}/update")
	public String updateProduct(@ModelAttribute Tariff tariff, Model model) {// здесь мы уже принимаем данные из формы
																				// изменения объекта
		try {
			ProductDao.update(tariff);
			// message_action = "Successfully updated";
			// model.addAttribute("message_action", message_action);
		} catch (DaoSQLException e) {
			model.addAttribute("message_action", "Problems with changing product.");
			return "redirect:/catalog";
		}
		return "redirect:/catalog";
	}
}