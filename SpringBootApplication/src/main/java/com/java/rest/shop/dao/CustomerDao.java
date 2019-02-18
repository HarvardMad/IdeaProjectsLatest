package com.java.rest.shop.dao;

import com.java.rest.shop.model.Customer;

/**
 * Created by LalinPethiyagoda on 04/06/2017.
 */
public interface CustomerDao {

    void registerCustomer(Customer customer);
    Customer getCustomerById(int id);

    Customer getCustomerByUserName(String username);
}
