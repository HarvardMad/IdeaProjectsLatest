package com.java.rest.shop.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by LalinPethiyagoda on 30/10/2017.
 */
@Entity(name ="Customer")
@Table(name="customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 294233768877526053L;

    @Id
    @GeneratedValue
    private int customerId;

    @NotEmpty(message = "The customer name must nt be nulll")
    private String customerName;

    @NotEmpty(message = " The customer email cannot be null")
    private String customerEmail;

    private String customerPhone;

    @NotEmpty(message = " The customer username cannot be null")
    private String username;

    @NotEmpty(message = " The customer password cannot be null")
    private String password;

    @NotEmpty(message = " The client type password cannot be null")
    private String clientType;

    private boolean enabled;

    /*@OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="shippingAddressId")
    private ShippingAddress shippingAddress;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cartId")
    @JsonIgnore
    private Cart cart;*/

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }


   /* public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }*/

}
