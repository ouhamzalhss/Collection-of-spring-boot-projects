package com.ouhamza.springboot.demo.myApp.service;

import com.ouhamza.springboot.demo.myApp.dao.CustomDaoI;
import com.ouhamza.springboot.demo.myApp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lhouceine OUHAMZA
 */
@Service
public class CustomerServiceImpl implements CustomerServiceI {
    @Autowired
    @Qualifier("customerDaoImplJPA")
    private CustomDaoI customDaoI;

    @Override
    @Transactional
    public List<Customer> findAll() {
        return customDaoI.findAll();
    }

    @Override
    @Transactional
    public Customer findById(int theId) {
        return customDaoI.findById(theId);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
       customDaoI.save(customer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
       customDaoI.deleteById(theId);
    }
}
