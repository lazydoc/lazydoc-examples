package org.lazydoc.example.extended.entity;

import org.lazydoc.annotation.PropertyDescription;
import org.lazydoc.annotation.Sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @PropertyDescription(description = "The unique identifier of the customer")
    private long customerId;

    @PropertyDescription(description = "The lastname of the customer")
    @Sample("Miller")
    private String lastname;

    @PropertyDescription(description = "The firstname of the customer")
    @Sample("Maxi")
    private String firstname;

    @PropertyDescription(description = "The street of the customer's address")
    @Sample("Effnerstr. 5")
    private String street;

    @PropertyDescription(description = "The zipcode of the customer's address")
    private String zipCode;

    @PropertyDescription(description = "The city of the customer's address")
    private String city;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
