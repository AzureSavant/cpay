package com.skynet.cpay.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String TransactionCasys;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", Transaction='" + TransactionCasys + '\'' +
                '}';
    }

    public String getTransactionCasys() {
        return TransactionCasys;
    }

    public void setTransactionCasys(String transaction) {
        TransactionCasys = transaction;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transaction(String transaction) {

        TransactionCasys = transaction;
    }

    public Transaction() {

    }
}
