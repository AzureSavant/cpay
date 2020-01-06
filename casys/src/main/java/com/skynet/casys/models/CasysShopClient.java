package com.skynet.casys.models;


import javax.persistence.*;

@Entity
public class CasysShopClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String shopLink;

    private String shopLinkRef;

    public CasysShopClient(String shopLink, String shopLinkRef) {
        this.shopLink = shopLink;
        this.shopLinkRef = shopLinkRef;
    }

    public CasysShopClient() {
    }

    @Override
    public String toString() {
        return "CasysShopClient{" +
                "ShopLink='" + shopLink + '\'' +
                ", ShopLinkRef='" + shopLinkRef + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopLink() {
        return shopLink;
    }

    public void setShopLink(String shopLink) {
        this.shopLink = shopLink;
    }

    public String getShopLinkRef() {
        return shopLinkRef;
    }

    public void setShopLinkRef(String shopLinkRef) {
        this.shopLinkRef = shopLinkRef;
    }
}
