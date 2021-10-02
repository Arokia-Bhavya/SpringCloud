package com.abc.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlertsController {
	
	@GetMapping("/info")
	public ResponseEntity<String> getMessage()
	{
		return ResponseEntity.ok("Alert !!!!");
	}

	
}
