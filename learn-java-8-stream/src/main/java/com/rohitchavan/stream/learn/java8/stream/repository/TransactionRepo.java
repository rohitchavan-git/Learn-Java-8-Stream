package com.rohitchavan.stream.learn.java8.stream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohitchavan.stream.learn.java8.stream.entity.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

}
