package com.java.rest.shop.api;

import com.java.rest.shop.model.Customer;
import com.java.rest.shop.model.CustomerRequest;
import com.java.rest.shop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by LalinPethiyagoda on 30/10/2017.
 */
@RestController
public class RegisterController {

    @Autowired
    CustomerService customerService;
    @RequestMapping(value="/register" , method = RequestMethod.POST)
    public ResponseEntity<String> registerCustoemr(@Valid @RequestBody CustomerRequest newCustomer, HttpServletRequest request){
        Customer newCustomerForDao = new Customer();
        newCustomerForDao.setClientType(newCustomer.getClientType());
        newCustomerForDao.setCustomerName(newCustomer.getCustomerName());
        newCustomerForDao.setCustomerEmail(newCustomer.getCustomerEmail());
        newCustomerForDao.setCustomerPhone(newCustomer.getCustomerPhone());
        newCustomerForDao.setUsername(newCustomer.getUsername());
        newCustomerForDao.setPassword(newCustomer.getPassword());

        customerService.registerCustomer(newCustomerForDao);
        return new ResponseEntity<>("hello New Client", HttpStatus.OK);
    }

    @GetMapping(value = "/getReg")
    public ResponseEntity<String> viewRegistration(){
        return new ResponseEntity<String>("registered",new HttpHeaders(),HttpStatus.OK);
    }




}
