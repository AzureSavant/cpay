package com.skynet.casys.service;

import com.skynet.casys.models.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionService {
    List<Transaction> getAllTransactions();
    Transaction getById (int id);
    void saveTransaction (Transaction transaction);
}
