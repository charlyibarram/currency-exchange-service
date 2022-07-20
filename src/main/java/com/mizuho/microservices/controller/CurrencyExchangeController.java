package com.mizuho.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mizuho.microservices.entity.CurrencyExchange;
import com.mizuho.microservices.repository.CurrencyExchangeRepository;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		 CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);

		 if(currencyExchange==null) {
			 throw new RuntimeException("Unable to find data for="+from+" to=" +to);
		 }
		String port=env.getProperty("local.server.port");
		 currencyExchange.setEnv(port);
		return currencyExchange;
		
	}
}
