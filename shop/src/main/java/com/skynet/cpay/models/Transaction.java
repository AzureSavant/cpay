package com.skynet.cpay.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    private CreditCard creditCard;

    private double cost;

    public Transaction(Product product, CreditCard creditCard, double cost) {
        this.product = product;
        this.creditCard = creditCard;
        this.cost = cost;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "product{" + product.toString()+"} " +
                ", from{" + creditCard.toString()+"} " +
                ", cost=" + cost +
                '}';
    }
}
