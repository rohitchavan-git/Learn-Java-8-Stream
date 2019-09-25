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



/**
 * 1.Find all transactions in the year 2011 and sort them by value (small to high).
 * 2.What are all the unique cities where the traders work?
 * 3.Find all traders from Nanded and sort them by name.
 * 4.Return a string of all traders’ names sorted alphabetically.
 * 5.Are any traders based in Osmanabad?
 * 6.Print all transactions’ values from the traders living in Nanded.
 * 7.What’s the highest value of all the transactions?
 * 8.Find the transaction with the smallest value.
 */
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
	/**
	 * 1.Find all transactions in the year 2011 and sort them by value (small to high).
	 * SQL:
	 */
	@Test
	public void findAllYear2011() {
		
	}
	
	
	/**
	 * 2.What are all the unique cities where the traders work?
	 * SQL:
	 */
	@Test
	public void allUniqueCity() {
		
	}
	
	/**
	 * 3.Find all traders from Nanded and sort them by name.
	 * SQL:
	 */
	@Test
	public void allTradersNanded() {
		
	}
	/**
	 * 4.Return a string of all traders’ names sorted alphabetically.
	 * SQL:
	 */
	@Test
	public void allTradersSorted() {
		
	}
	
	/**
	 * 5.Are any traders based in Osmanabad?
	 * SQL:
	 */
	@Test
	public void anyTradersInOsbad() {
		
	}
	/**
	 * 6.Print all transactions’ values from the traders living in Nanded.
	 * SQL:
	 */
	@Test
	public void allTransaction() {
		
		
	}
	
	/**
	 * 7.What’s the highest value of all the transactions?
	 * SQL:
	 */
	@Test
	public void highTransaction() {
		
	}
	/**
	 * 8.Find the transaction with the smallest value.
	 * SQL:
	 */
	@Test
	public void transactionSmall() {
		
	}
	
	
	
	
}
