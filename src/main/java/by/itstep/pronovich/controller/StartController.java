package by.itstep.pronovich.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
	private static final Logger log = LoggerFactory.getLogger(StartController.class);

	@GetMapping("/start")
	public String start() {
		log.info("show start page");
		return "start";
	}

	@GetMapping("/")
	public String home() {
		log.info("show start page");
		return "start";
	}

}
