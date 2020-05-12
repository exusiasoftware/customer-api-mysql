package com.exusiasoftware.customerapi;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.exusiasoftware.customerapi.entities.Customer;


@Consumes("application/json")
@Produces("application/json")
@Path("/customerservice/")
public interface CustomerService {
	
	@Path("/customers")
	@GET
	List<Customer> getCustomers();
	
	@Path("/customers/{id}")
	@GET
	Customer getCustomer(@PathParam("id")int id);
	
	@Path("/customers")
	@POST
	Response createCustomer(Customer customer);
	
	@Path("/customers")
	@PUT
	Response updateCustomer(Customer customer);
	

}
