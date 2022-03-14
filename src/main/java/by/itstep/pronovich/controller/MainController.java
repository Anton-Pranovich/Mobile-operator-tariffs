package by.itstep.pronovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.itstep.pronovich.model.Tariff;

@Controller
public class MainController {

	@RequestMapping(value = { "/addTariff" })
	public String staticResource(Model model) {
		model.addAttribute("tariff", new Tariff());
		return "addTariff";
	}
}
