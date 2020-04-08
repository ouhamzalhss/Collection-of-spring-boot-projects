package com.ouhamza.springboot.demo.myApp.service;

import com.ouhamza.springboot.demo.myApp.dao.CustomerRepo;
import com.ouhamza.springboot.demo.myApp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Lhouceine OUHAMZA
 */
@Service
public class CustomerServiceImpl implements CustomerServiceI {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    @Transactional
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    @Transactional
    public Customer findById(int theId) {

        Optional<Customer> result = customerRepo.findById(theId);
        Customer customer = null;
        if(result.isPresent()){
            customer  = result.get();
        }else{
            throw new RuntimeException("Did not find customer id: "+theId);
        }
        return customer;
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerRepo.deleteById(theId);
    }
}
