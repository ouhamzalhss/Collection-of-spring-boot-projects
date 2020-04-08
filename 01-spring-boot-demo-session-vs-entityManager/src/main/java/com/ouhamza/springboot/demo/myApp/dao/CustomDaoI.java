package com.ouhamza.springboot.demo.myApp.dao;

import com.ouhamza.springboot.demo.myApp.entity.Customer;

import java.util.List;

/**
 * @author Lhouceine OUHAMZA
 */

public interface CustomDaoI {

    public List<Customer> findAll();
    public Customer findById(int theId);
    public void save(Customer customer);
    public void deleteById(int theId);
}
