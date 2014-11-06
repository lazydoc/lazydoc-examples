package org.lazydoc.example.extended.entity;

import org.lazydoc.annotation.PropertyDescription;
import org.lazydoc.annotation.Sample;

import java.util.Date;

public class Product {

    @PropertyDescription(description = "The unique identifier of the product")
    private long id;
    @PropertyDescription(description = "The name of the product")
    @Sample("Our new product")
    private String productName;
    @PropertyDescription(description = "The status of the product")
    @Sample("IN_EDIT_MODE")
    private ProductStatus status;
    @PropertyDescription(description = "The date when the product was created")
    private Date creationDate;
    @PropertyDescription(description = "Flag if the product was already booked")
    private boolean booked;

    public enum ProductStatus {
        ACTIVE, IN_EDIT_MODE, DEACTIVATED;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
