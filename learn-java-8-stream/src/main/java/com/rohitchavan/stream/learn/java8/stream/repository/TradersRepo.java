package com.rohitchavan.stream.learn.java8.stream.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohitchavan.stream.learn.java8.stream.entity.Trader;

public interface TradersRepo extends JpaRepository<Trader, Long> {
	Trader findByName(String name);
}
