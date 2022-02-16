/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingServiceCustomer.resources;

import com.mycompany.bankingServiceCustomer.models.Customer;
import com.mycompany.bankingservicecustomer.services.CustomerService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author shaug
 */
@Path("/customers")
public class CustomerResource {
    CustomerService customerService=new CustomerService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public List<Customer>getFilteredCustomers(@QueryParam("name")String name,@QueryParam("email")String email){
        if((name!=null)||(email!=null)){
            return customerService.getSearchCustomers(name, email);
        }
        return customerService.getAllCustomers();
    }
    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerJSON(@PathParam("customerId")int id){
        return customerService.getCustomer(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer createCustomer(Customer customer){
        return customerService.addCustomer(customer);
    }
    @Path("/{customerId}/accounts")
    public AccountsResource getAccountResource(){
        return new AccountsResource();
    }
}
