package com.abc.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abc.bank.model.Account;

@SpringBootApplication
@RestController
public class LoadBalancerApplication {
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping("/")
	public Account hello() {
		return restTemplate().getForObject("http://BANK-ACCOUNT-SERVICE/account/A12345", Account.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerApplication.class, args);
	}

}
