package com.skynet.casys.repositories;

import com.skynet.casys.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    @Override
    List<Transaction> findAll();

    Transaction getTransactionById(Integer Integer);
}
