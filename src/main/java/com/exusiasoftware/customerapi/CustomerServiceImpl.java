package com.exusiasoftware.customerapi;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.exusiasoftware.customerapi.entities.Customer;
import com.exusiasoftware.customerapi.repos.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	
	
	@Autowired
	CustomerRepository repository;
	
	
	
	@Override
	public List<Customer> getCustomers() {
	
		return repository.findAll();
	}

	@Override
	public Customer getCustomer(int id) {
	
		return repository.findById(id).get();
	}

	@Override
	public Response createCustomer(Customer customer) {
		
		Customer savedCustomer = repository.save(customer);
		return Response.ok(savedCustomer).build();
	}

	@Override
	public Response updateCustomer(Customer customer) {
		 
		Customer savedCustomer = repository.save(customer);
		return Response.ok(savedCustomer).build();
	}

}
