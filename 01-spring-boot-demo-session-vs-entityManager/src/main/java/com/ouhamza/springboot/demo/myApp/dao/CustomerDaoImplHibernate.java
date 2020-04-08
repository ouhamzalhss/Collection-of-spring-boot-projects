package com.ouhamza.springboot.demo.myApp.dao;

import com.ouhamza.springboot.demo.myApp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Lhouceine OUHAMZA
 */
@Repository
public class CustomerDaoImplHibernate implements CustomDaoI {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        Session session = entityManager.unwrap(Session.class);
        Query<Customer> query = session.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public Customer findById(int theId) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = session.get(Customer.class, theId);
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);

    }

    @Override
    public void deleteById(int theId) {
        Session session = entityManager.unwrap(Session.class);

        Query theQuery = session.createQuery("delete from Customer where id =:idParam");
        theQuery.setParameter("idParam", theId);
        theQuery.executeUpdate();
    }
}
