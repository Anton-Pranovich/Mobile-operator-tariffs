package by.itstep.pronovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StartController {
	
	@GetMapping( "/start")
	public String start() {
		return "start";
	}
	
	@GetMapping("/")
	public String home() {
		return "start";
	}
	@GetMapping( "/admin")
	public String admin() {
		return "admin";
	}
}
