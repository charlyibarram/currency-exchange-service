package com.mizuho.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mizuho.microservices.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);
}
