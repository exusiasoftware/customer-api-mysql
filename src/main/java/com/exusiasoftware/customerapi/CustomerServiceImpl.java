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
	public Response getCustomers() {
		List<Customer> customers = repository.findAll();
		return Response.ok(customers).build();
	}

	@Override
	public Response getCustomer(int id) {
		Customer customer = repository.findById(id).get();
		return Response.ok(customer).build();
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
