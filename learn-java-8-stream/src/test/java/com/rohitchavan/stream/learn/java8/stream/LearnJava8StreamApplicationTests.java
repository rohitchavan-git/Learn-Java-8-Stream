package com.rohitchavan.stream.learn.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
	 * Supply all Transactions
	 */
	public Supplier<List<Transaction>> allTranscation=()->{
		return  transactionRepo.findAll();
	};
	
	/**
	 * Supply All Traders
	 */
	
	public Supplier<List<Trader>> allTrader=()->{
		return  tradersRepo.findAll();
	};
	
	/**
	 * 1.Find all transactions in the year 2011 and sort them by value (small to high).
	 * SQL:select * from Transactions where year=2011 order by value asc
	 * 
	 * 
	 * Stream().filter  (Logically Similar To) where clause in sql
	 * 
	 * Stream().sorted  (Logically Similar To)  Order By in sql
	 */
	
	@Test
	public void findAllYear2011() {
		
		List<Transaction> allTranscations = allTranscation.get();
		
		List<Transaction> result = allTranscations.stream().filter(p->p.getYear()==2011)
					   .sorted(Comparator.comparing(Transaction::getValue))
					   .collect(Collectors.toList());
		
	}
	
	
	/**
	 * 2.What are all the unique cities where the traders work?
	 * SQL:select DISTINCT city from trader
	 * 
	 * map (logically similar to) sql projection 
	 */
	@Test
	public void allUniqueCity() {
		List<Trader> allTraders = allTrader.get();
		List<String> result = allTraders.stream()
										.map(Trader::getCity)
										.distinct()
										.collect(Collectors.toList());
		
	}
	
	/**
	 * 3.Find all traders from Nanded and sort them by name.
	 * SQL:select * FROM trader WHERE city like "nanded" ORDER by name ASC
	 */
	@Test
	public void allTradersNanded() {
		List<Trader> allTraders = allTrader.get();
		allTraders.stream().filter(p->p.getCity()
						   .equalsIgnoreCase("nanded"))
						   .sorted(Comparator.comparing(Trader::getName))
						   .collect(Collectors.toList());
	}
	/**
	 * 4.Return a string of all traders's names sorted alphabetically.
	 * SQL:select name FROM trader  ORDER by name ASC
	 */
	@Test
	public void allTradersSorted() {
		List<Trader> allTraders = allTrader.get();
		String allNameJoined = allTraders.stream().map(p->p.getName())
		 				   .sorted()
		 				   .collect(Collectors.joining());
	}
	
	/**
	 * 5.Are any traders based in Osmanabad?
	 * SQL:
	 */
	@Test
	public void anyTradersInOsbad() {
		List<Transaction> allTranscations = allTranscation.get();
		boolean anyMatch = allTranscations.stream().map(transcation->transcation.getTrader())
					   			.anyMatch(trader->trader.getCity().equalsIgnoreCase("Osmanabad"));
		if(anyMatch) {
			allTranscations.stream()
						.map(transaction->transaction.getTrader())
						.filter(trader->trader.getCity()
						.equalsIgnoreCase("Osmanabad")).collect(Collectors.toList());
					
		}	
		
	}
	/**
	 * 6.Print all transactions’ values from the traders living in Nanded.
	 * SQL:select value from transaction WHERE trader_id IN (select id from trader WHERE city like 'nanded');
	 */
	@Test
	public void allTransaction() {
		List<Transaction> allTranscations = allTranscation.get();
		allTranscations.stream().filter(transaction->transaction.getTrader()
								.getCity().equalsIgnoreCase("Nanded"))
								.map(trader->trader.getValue())
								.forEach(System.out::println);;
							
	}
	
	/**
	 * 7.What’s the highest value of all the transactions?
	 * SQL:select sum(value) from transaction 
	 */
	@Test
	public void highTransaction() {
		List<Transaction> allTranscations = allTranscation.get();
		
		Optional<Integer> hightValue = allTranscations.stream().map(trancaction->trancaction.getValue()).reduce(Integer::sum);
	}
	/**
	 * 8.Find the transaction with the smallest value.
	 * SQL:select * from transaction where VALUE=(SELECT min(value) from transaction);
	 */
	@Test
	public void transactionSmall() {
		List<Transaction> allTranscations = allTranscation.get();
		Optional<Transaction> smallValue = allTranscations.stream()
										.reduce((t1,t2)->t1.getValue()>t2.getValue()?t2:t1);
		
		/**
		 * another way
		 */
		Optional<Transaction> smallestTransaction =
				allTranscations.stream()
				.min(Comparator.comparing(Transaction::getValue));
		
	}
	
	
	
	
}
