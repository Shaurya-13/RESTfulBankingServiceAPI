/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingServiceCustomer.services;

import com.mycompany.bankingServiceCustomer.models.Accounts;
import com.mycompany.bankingServiceCustomer.models.Customer;
import com.mycompany.bankingServiceCustomer.models.Transactions;
import com.mycompany.bankingservicecustomer.databases.Database;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author shaug
 */
public class TransactionsService {
    private List<Customer>customerList=new Database().getCustomersDB();
    private List<Transactions>transactionsList=new Database().getTransactionsDB();
    
    public List<Transactions>getAllTransactionsByAccount(int customerId,int accountId){
        return customerList.get(customerId-1).getAccounts().get(accountId-1).getTransactions();
    }
    public Transactions getTransactionById(int customerId,int accountId,int transactionId){
        return customerList.get(customerId-1).getAccounts().get(accountId-1).getTransactions().get(transactionId-1);
    }
    public List<Transactions> getAllTransactions(){
        return transactionsList;
    }
    public String createTransaction(Transactions transaction, int accountId,int customerId,String transactionKeyword, int transactionAmount,String transactionType){
    Accounts account=customerList.get(customerId-1).getAccounts().get(accountId-1);
    transaction.setId(account.getTransactions().size()+1);//id
    SimpleDateFormat simpleFormat=new SimpleDateFormat("dd MMMM yyyy");
    transaction.setDate(simpleFormat.format(new Date()));
    transaction.setTransactionAmount(transactionAmount);
    transaction.setTransactionKeyword(transactionKeyword);
    transaction.setTransactionType(transactionType);
    transaction.setDescription(transactionKeyword+" "+transactionAmount);//description
    if(transactionKeyword.equalsIgnoreCase("lodgement")||transactionKeyword.equalsIgnoreCase("deposit")){
        transaction.setPostAccountBalance(account.getCurrentAccountBalance()+transactionAmount);//balance
        account.setCurrentAccountBalance(transaction.getPostAccountBalance());
        account.addTransactionToAccount(transaction);
    }
    else if(transactionKeyword.equalsIgnoreCase("withdrawal")||transactionKeyword.equalsIgnoreCase("withdraw")){
        if(transactionAmount>account.getCurrentAccountBalance()){
            System.out.println("Invalid transaction, Not enough money for requested withdrawal");
            transaction.setPostAccountBalance(account.getCurrentAccountBalance());
            return "Invalid transaction not enough money in choosen account"+"\n"+" The current account balance is "+account.getCurrentAccountBalance()+" and the transaction amount is "+transactionAmount;
        }
        else{
            transaction.setPostAccountBalance(account.getCurrentAccountBalance()-transactionAmount);//balance
            account.setCurrentAccountBalance(transaction.getPostAccountBalance()); 
        }
        account.addTransactionToAccount(transaction);
    }
    
    System.out.println("201 - resource created with path: /accounts/" + String.valueOf(account.getId())+"/transactions/"+String.valueOf(transaction.getId()));
    System.out.println("Updated Customer:"+transaction.printTransactionDetails());
    return "transaction successfully made to account "+accountId+" for customer "+customerId;
    }
    public String transfer(int currCustomerId, int currAccountId, int recCustomerId, int recAccountId, int transactionAmount, Transactions transactions){

        Accounts account=customerList.get(currCustomerId-1).getAccounts().get(currAccountId-1);
        SimpleDateFormat simpleFormat=new SimpleDateFormat("dd MMMM yyyy");
        transactions.setDate(simpleFormat.format(new Date()));
        if(transactionAmount>account.getCurrentAccountBalance()){
            return "Sorry insuffecient balance for transfer transaction requested. "+"\n"+"The current account balance is: "+account.getCurrentAccountBalance()+" and the amount requested to be transferred is: "+transactionAmount;
        }
        else{
            //for withdrawl from the current account in use
            transactions.setId(account.getTransactions().size()+1);//id
            transactions.setTransactionAmount(transactionAmount);
            transactions.setPostAccountBalance(account.getCurrentAccountBalance()-transactionAmount);//balance
            account.setCurrentAccountBalance(transactions.getPostAccountBalance());
            account.addTransactionToAccount(transactions);
            
            //for depositing in recieving account
            Accounts recAccount=customerList.get(recCustomerId-1).getAccounts().get(recAccountId-1);
            Transactions recTransaction=new Transactions();
            recTransaction.setId(recAccount.getTransactions().size()+1);//id
            recTransaction.setTransactionAmount(transactionAmount);
            recTransaction.setPostAccountBalance(recAccount.getCurrentAccountBalance()+transactionAmount);//balance
            recAccount.setCurrentAccountBalance(recTransaction.getPostAccountBalance());
            recAccount.addTransactionToAccount(recTransaction);
            return "Transfer of "+transactionAmount+" is succesful from customer "+currCustomerId+" account "+currAccountId+" to customer "+recCustomerId+" account "+recAccountId;
        }
    }
}
