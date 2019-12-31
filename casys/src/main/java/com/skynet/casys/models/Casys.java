package com.skynet.casys.models;

public class Casys {
  private int id;
  private String product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Casys(int id, String product) {

        this.id = id;
        this.product = product;
    }
}
