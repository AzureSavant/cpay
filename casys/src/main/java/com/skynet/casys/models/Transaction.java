package com.skynet.casys.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private String productName;

    @OneToOne(cascade = CascadeType.ALL)
    private  CreditCard creditCard;

    private double cost;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", product='" + productName + '\'' +
                ", creditCard=" + creditCard +
                ", cost=" + cost +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {

        return productName;
    }

    public void setProduct(String product) {
        this.productName = product;
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


    public Transaction(String product, CreditCard creditCard, double cost) {

        this.productName = product;
        this.creditCard = creditCard;
        this.cost = cost;
    }
}
