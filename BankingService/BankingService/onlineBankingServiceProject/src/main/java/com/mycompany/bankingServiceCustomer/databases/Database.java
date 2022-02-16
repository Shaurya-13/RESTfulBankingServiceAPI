    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingservicecustomer.databases;

import com.mycompany.bankingServiceCustomer.models.Accounts;
import com.mycompany.bankingServiceCustomer.models.Customer;
import com.mycompany.bankingServiceCustomer.models.Transactions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shaug
 */
public class Database {
    public static List<Customer> customerDB=new ArrayList<>();
    public static List<Accounts> accountDB=new ArrayList<>();
    public static List<Transactions> transactionDB=new ArrayList<>();
    public static boolean init=true;
    
    public Database(){
        if(init){
            Customer c1=new Customer(1,"SK","Dublin1, IFSC, Ireland","sk@gmail.com",5432);
            Customer c2=new Customer(2,"Boris","Dublin6, Rathfarnham, Ireland","boris@gmail.com",3254);
            Customer c3=new Customer(3,"Mecgregor","Ballymore, Ireland","conor@gmail.com",2534);
            customerDB.add(c1);
            customerDB.add(c2);
            customerDB.add(c3);
            init=false;
        }
    }
    public static List<Customer> getCustomersDB(){
        return customerDB;
    }
    public static List<Accounts> getAccountsDB(){
        return accountDB;
    }
    public static List<Transactions> getTransactionsDB(){
        return transactionDB;
    }
}
