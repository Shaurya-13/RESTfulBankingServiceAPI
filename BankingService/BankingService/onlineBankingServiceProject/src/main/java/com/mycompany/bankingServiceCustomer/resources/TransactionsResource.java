/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingServiceCustomer.resources;

import com.mycompany.bankingServiceCustomer.models.Accounts;
import com.mycompany.bankingServiceCustomer.models.Transactions;
import com.mycompany.bankingServiceCustomer.services.TransactionsService;
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
@Path("/transactions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionsResource {
    private TransactionsService transactionService = new TransactionsService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transactions> getTransactions(@PathParam("customerId")int customerId,@PathParam("accountId") int accountId) {
        System.out.println("getAllTransactionsForAccountsforCustomers..."+accountId+customerId);
	return transactionService.getAllTransactionsByAccount(customerId,accountId);
    }
    @GET
    @Path("/{transactionType}/{transactionKeyword}/{transactionAmount}")
    public Response postTransaction(@PathParam("accountId") int accountId, @PathParam("customerId")int customerId,Transactions transaction,@PathParam("transactionKeyword")String transactionKeyword,@PathParam("transactionAmount")int transactionAmount,@PathParam("transactionType")String transactionType) {
        String createdTransaction=transactionService.createTransaction(transaction, accountId, customerId,transactionKeyword,transactionAmount,transactionType);
        return Response.status(200).entity(createdTransaction).build();
    }
    @GET
    @Path("/transfer/{recCustomerId}/{recAccountId}/{transactionAmount}")
    public Response transferTransaction(@PathParam("accountId") int crrAccountId, @PathParam("customerId")int currCustomerId,Transactions transaction,@PathParam("transactionAmount")int transactionAmount,@PathParam("recCustomerId")int recCustomerId,@PathParam("recAccountId")int recAccountId){
        String transferResponse=transactionService.transfer(currCustomerId, crrAccountId, recCustomerId, recAccountId, transactionAmount, transaction);
        return Response.status(200).entity(transferResponse).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{transactionId}")
    public Transactions getTransaction(@PathParam("customerId")int customerId,@PathParam("accountId") int accountId,@PathParam("transactionId") int transactionId) {
    	System.out.println("getTransactionByID..."+transactionId +" for AccountID "+accountId+" for customerId "+customerId);
	return transactionService.getTransactionById(customerId,accountId,transactionId);
    }
    
}
