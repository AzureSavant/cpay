package com.skynet.casys.models;

import javax.persistence.*;

@Entity
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String eMail;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private CreditCard creditCard;

    public Client(String name, String eMail, String phoneNumber, CreditCard creditCard) {
        this.name = name;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.creditCard = creditCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
