package br.com.itau.techinsiders.ibank.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@GetMapping("/")
	private String status() {
		return "{\"status\": \"running\"}";
	}
	
}
