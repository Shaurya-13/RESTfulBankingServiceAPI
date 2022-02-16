/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingServiceCustomer.services;

import com.mycompany.bankingServiceCustomer.models.Accounts;
import com.mycompany.bankingServiceCustomer.models.Customer;
import com.mycompany.bankingservicecustomer.databases.Database;
import java.util.List;

/**
 *
 * @author shaug
 */
public class AccountsService {
    
    private List<Customer>customerList=new Database().getCustomersDB();
    private List<Accounts>accountsList=new Database().getAccountsDB();
    
    public List<Accounts>getAllAccountsByCustomer(int customerId){
        return customerList.get(customerId-1).getAccounts();
    }
    public Accounts getAccountById(int customerId,int accountId){
        return customerList.get(customerId-1).getAccounts().get(accountId-1);
    }
    public List<Accounts> getAllAccounts(){
        return accountsList;
    }
    public Accounts createAccount(Accounts account,int custId){
        Customer customer=customerList.get(custId-1);
        account.setId(customer.getAccounts().size() + 1);
        customer.addAccountToCustomer(account);
        account.setCurrentAccountBalance(account.getInitialAccountBalance());
        System.out.println("201 - resource created with path: /customer/" + String.valueOf(customer.getId())+"/accounts/"+String.valueOf(account.getId()));
        System.out.println("Updated Customer:"+account.printAccountDetails());
        return account;
    }
    public double getBalance(int customerId,int accountId, Accounts account){
        account.setCurrentAccountBalance(account.getInitialAccountBalance());
        return customerList.get(customerId-1).getAccounts().get(accountId-1).getCurrentAccountBalance();
    }
}
