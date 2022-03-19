package by.itstep.pronovich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StartController {
	
	@GetMapping("/start")
	public String start() {
		return "start";
	}
	
	@GetMapping("/user/start")
	public String userStart() {
		return "start";
	}
	
	
	@GetMapping("/")
	public String home() {
		return "start";
	}

}
