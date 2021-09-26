package com.abc.bank.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix="account-service")
public class Configuration {
	@Setter
	@Getter
	private Double minBalance;
	
	@Setter
	@Getter
	private Double maxBalance;
}
