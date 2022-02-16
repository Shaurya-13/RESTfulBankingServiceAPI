/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingServiceCustomer.resources;

import com.mycompany.bankingServiceCustomer.models.Accounts;
import com.mycompany.bankingServiceCustomer.services.AccountsService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 *
 * @author shaug
 */

@Path("/accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountsResource {
    
   private AccountsService accountService = new AccountsService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Accounts> getAccounts(@PathParam("customerId") int custId) {
        System.out.println("getAllAccountsForCustomer..."+custId);
	return accountService.getAllAccountsByCustomer(custId);
    }	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Accounts postAccount(@PathParam("customerId") int  custId, Accounts account) {
	return accountService.createAccount(account, custId);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{accountId}")
    public Accounts getAccount(@PathParam("accountId") int accId,@PathParam("customerId") int custId) {
    	System.out.println("getAccountByID..."+accId +" for CustomerID "+custId);
	return accountService.getAccountById(custId,accId);
    }
    @GET
    @Path("/{accountId}/balance")
    public Response getAccountBalance(@PathParam("accountId") int accId,@PathParam("customerId") int custId, Accounts account){
        double balance=accountService.getBalance(custId,accId, account);
        return Response.status(200).entity("The current account balance for this account is: "+Double.toString(balance)).build();
    }
    @Path("/{accountId}/transactions")
    public TransactionsResource getTransactionResource(){
        return new TransactionsResource();
    }
}
