package com.ouhamza.springboot.demo.myApp.service;

import com.ouhamza.springboot.demo.myApp.entity.Customer;

import java.util.List;

/**
 * @author Lhouceine OUHAMZA
 */

public interface CustomerServiceI {
    public List<Customer> findAll();
    public Customer findById(int theId);
    public void save(Customer customer);
    public void deleteById(int theId);
}
