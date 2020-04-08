package com.ouhamza.springboot.demo.myApp.dao;

import com.ouhamza.springboot.demo.myApp.entity.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Lhouceine OUHAMZA
 */
@Repository
public class CustomerDaoImplJPA implements CustomDaoI {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        Query query = entityManager.createQuery("from Customer");
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer findById(int theId) {
        Customer customer = entityManager.find(Customer.class, theId);
        return customer;
    }

    @Override
    public void save(Customer customer) {
       Customer dbCustomer= entityManager.merge(customer);
        customer.setId(dbCustomer.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery = entityManager.createQuery("delete from Customer where id =:idParam");
        theQuery.setParameter("idParam", theId);
        theQuery.executeUpdate();
    }
}
