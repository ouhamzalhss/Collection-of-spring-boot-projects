package com.ouhamza.springboot.demo.myApp.rest;

import java.util.List;

import com.ouhamza.springboot.demo.myApp.entity.Customer;
import com.ouhamza.springboot.demo.myApp.service.CustomerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerServiceI customerServiceI;
		
	// expose "/" that return "Hello World"
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerServiceI.findAll();
	}

	@GetMapping("/customers/{theId}")
	public Customer getCustomer(@PathVariable int theId) {

		Customer customer = customerServiceI.findById(theId);
		if(customer == null){
			throw new RuntimeException("Customer id not found" + theId);
		}
		return customerServiceI.findById(theId);
	}

	@PostMapping("/customers")
	public Customer save(@RequestBody Customer customer){
		customer.setId(0);
		customerServiceI.save(customer);
		return customer;
	}

	@PutMapping("/customers")
	public Customer update(@RequestBody Customer customer){
		customerServiceI.save(customer);
		return customer;
	}

	@DeleteMapping("/customers/{theId}")
	public String save(@PathVariable int theId){

		Customer customer = customerServiceI.findById(theId);
		if(customer == null){
			throw new RuntimeException("Customer id not found" + theId);
		}
		customerServiceI.deleteById(theId);
		return "Deleted custome id "+ theId;
	}


}












