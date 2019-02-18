package com.java.rest.shop.service;

import com.java.rest.shop.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LalinPethiyagoda on 04/06/2017.
 */
@Service
public interface CustomerService {
    void registerCustomer(Customer customer);
    Customer getCustomerById(int customerId);
    List<Customer>getCustomerByPostCode(String postCode);
    void updateCustomer(Customer customer);
    void deleteCustomer(Customer customer);

    Customer getCustomerByUserName(String username);
}
