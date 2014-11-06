package org.lazydoc.example.extended.entity;

import org.lazydoc.annotation.PropertyDescription;

public class ProductPrice {

    @PropertyDescription(description = "The unique identifier for the product price")
    private long id;
    @PropertyDescription(description = "The defined price of the product")
    private double price;
    @PropertyDescription(description = "The currency of the pricecs")
    private String currency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
