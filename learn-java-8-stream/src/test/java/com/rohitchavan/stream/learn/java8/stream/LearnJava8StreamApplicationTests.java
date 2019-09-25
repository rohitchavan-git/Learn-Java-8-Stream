package com.rohitchavan.stream.learn.java8.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rohitchavan.stream.learn.java8.stream.entity.Trader;
import com.rohitchavan.stream.learn.java8.stream.entity.Transaction;
import com.rohitchavan.stream.learn.java8.stream.repository.TradersRepo;
import com.rohitchavan.stream.learn.java8.stream.repository.TransactionRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnJava8StreamApplicationTests {
	
	
	@Autowired
	private TransactionRepo  transactionRepo;
	
	@Autowired
	private TradersRepo tradersRepo;

	@Test
	public void contextLoads() {
	}

	/**
	 * Add Traders into Database
	 */
	@Test
	public void addTraders() {
		Trader rohit = new Trader("Rohit", "Osmanabad");
		Trader amol = new Trader("Amol","Hyd");
		Trader urmila = new Trader("Urmila","Nanded");
		Trader nisha = new Trader("Nisha","Solapur");
		
		List<Trader> Traders = Arrays.asList(rohit,amol,urmila,nisha);
		tradersRepo.saveAll(Traders);
	}
	
	
	/**
	 * Add Transations into Database
	 */
	@Test
	public void addTransation() {
		
		Trader rohit = tradersRepo.findByName("Rohit");
		Trader amol = tradersRepo.findByName("amol");
		Trader urmila = tradersRepo.findByName("urmila");
		Trader nisha = tradersRepo.findByName("nisha");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(amol, 2011, 300),
				new Transaction(rohit, 2012, 1000),
				new Transaction(rohit, 2011, 400),
				new Transaction(urmila, 2012, 710),
				new Transaction(urmila, 2012, 700),
				new Transaction(nisha, 2012, 950)
				);
		
		transactionRepo.saveAll(transactions);
	}
	
	
}
