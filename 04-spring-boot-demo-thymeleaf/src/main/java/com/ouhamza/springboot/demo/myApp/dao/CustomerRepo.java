package com.ouhamza.springboot.demo.myApp.dao;

import com.ouhamza.springboot.demo.myApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lhouceine OUHAMZA
 */

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
