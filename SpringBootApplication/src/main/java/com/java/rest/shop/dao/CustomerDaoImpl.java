package com.java.rest.shop.dao;

//import com.springapp.model.Authorities;
//import com.springapp.model.Cart;

import com.java.rest.shop.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//import com.springapp.model.Users;

/**
 * Created by LalinPethiyagoda on 04/06/2017.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    public SessionFactory sessionFactory;//available directly from the application context
    @Override
    public void registerCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession(); //used as a singleton so need to access
        //it each time you wish to perform session methods
        session.saveOrUpdate(customer);
        //customer.getBillingAddress().setCustomer(customer);
        //customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);

        /*Users newUser = new Users();
        newUser.setEnabled(true);
        newUser.setUserName(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setCustomerId(customer.getCustomerId());

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        //set up a cart for the customer
        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(newCart);
        session.saveOrUpdate(customer); // because we updated the customer with cart details*/
        session.flush();
    }

    public Customer getCustomerById(int id){
        Session session = sessionFactory.getCurrentSession();
        return (Customer)session.get(Customer.class,id);
    }

    @Override
    public Customer getCustomerByUserName(String username) {
        Session session = sessionFactory.getCurrentSession();
        org.hibernate.Query query = session.createQuery("from Customer where username=?");
        query.setString(0,username);
        return (Customer)query.uniqueResult();
    }


}
