package com.java.rest.shop.service.impl;

import com.java.rest.shop.dao.CustomerDao;
import com.java.rest.shop.model.Customer;
import com.java.rest.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by LalinPethiyagoda on 04/06/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    protected CustomerDao customerDao;
    public CustomerServiceImpl(){}

   public void registerCustomer(Customer customer){
       customerDao.registerCustomer(customer);
    }

    public Customer getCustomerById(int customerId){

       return new Customer();
    }

    public List<Customer> getCustomerByPostCode(String postCode){
        return Collections.emptyList();
    }

    public void updateCustomer(Customer customer){

    }
    public void deleteCustomer(Customer customer){

    }

    @Override
    public Customer getCustomerByUserName(String username) {
        return customerDao.getCustomerByUserName(username);
    }
}
