package com.skynet.cpay.repositories;

import com.skynet.cpay.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface TransactionRepository extends JpaRepository<Transaction,Integer> {


    @Override
    List<Transaction> findAll();

    Transaction getTransactionById(Integer integer);
}
