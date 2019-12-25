package com.skynet.cpay.service;

import com.skynet.cpay.models.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionService {
    List<Transaction> getAllTransactions();
    Transaction getById(int id);
    void saveTransaction(Transaction transaction);
}
