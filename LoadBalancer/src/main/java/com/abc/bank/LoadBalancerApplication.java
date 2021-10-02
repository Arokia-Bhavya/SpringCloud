package com.abc.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/info")
	public String getInfo() {
		return restTemplate().getForObject("http://BANK-ACCOUNT-SERVICE/info",String.class);
	}
	
	@RequestMapping("/account/{accountId}")
	public Account getAccountDetails(@PathVariable String accountId) {
		return restTemplate().getForObject("http://BANK-ACCOUNT-SERVICE/account/"+accountId, Account.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerApplication.class, args);
	}

}
