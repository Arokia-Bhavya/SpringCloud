package com.abc.bank.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix="bank-account-service")
@Data
public class Configuration {
	private Double minBalance;
	private Double maxBalance;

}
