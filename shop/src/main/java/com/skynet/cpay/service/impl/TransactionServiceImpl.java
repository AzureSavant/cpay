package com.skynet.cpay.service.impl;

import com.skynet.cpay.models.Transaction;
import com.skynet.cpay.repositories.TransactionRepository;
import com.skynet.cpay.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {


    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionServiceImpl() {
    }

        @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getById(int id) {
        return transactionRepository.getTransactionById(id);
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        if(transaction != null){
            transactionRepository.save(transaction);
        }
        else{
            System.out.println("NULL TRANSACTION");
        }
    }
}
