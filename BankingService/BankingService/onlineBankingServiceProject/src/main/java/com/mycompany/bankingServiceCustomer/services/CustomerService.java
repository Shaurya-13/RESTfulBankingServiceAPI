package com.mycompany.bankingservicecustomer.services;

import com.mycompany.bankingServiceCustomer.models.Customer;
import com.mycompany.bankingservicecustomer.databases.Database;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shaug
 */
public class CustomerService {
    Database db=new Database();
    private List<Customer>customerList=db.getCustomersDB();
    
    public List<Customer>getAllCustomers(){
        return customerList;
    }
    public Customer getCustomer(int id) {
        return customerList.get(id-1);
    }
    public Customer addCustomer(Customer c){
        c.setId(customerList.size()+1);
        customerList.add(c);
        System.out.println("201 - resource created with path: /customers/" + String.valueOf(c.getId()));
        System.out.println("Updated Message:"+c.printCustomerDetails());
        return c;
    }
    public List<Customer>getSearchCustomers(String name,String email){
        List<Customer>list=new ArrayList<>();
        for(Customer c:getAllCustomers()){
            if((name == null || c.getName().equals(name)) 
                   && (email == null || c.getEmail().equals(email))){
                list.add(c);
            }
        }
        return list;
    }
}
