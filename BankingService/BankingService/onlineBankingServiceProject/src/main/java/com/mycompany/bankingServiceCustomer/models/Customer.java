/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingServiceCustomer.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shaug
 */
@XmlRootElement
public class Customer {
    private int id;
    private String name;
    private String address;
    private String email;
    private int pin;
    private List<Accounts>accountsList=new ArrayList<>();
    
    public Customer(){}
    public Customer(int id, String name, String address, String email, int pin, List<Accounts>accountsList){
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.pin=pin;
        this.accountsList=accountsList;
    }
    public Customer(int id, String name, String address, String email, int pin){
        this.id=id;
        this.name=name;
        this.address=address;
        this.email=email;
        this.pin=pin;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public List<Accounts> getAccounts() {
        return accountsList;
    }

    public void setAccounts(List<Accounts> accountsList) {
        this.accountsList = accountsList;
    }
    public String printCustomerDetails(){
        String str=this.getId()+" "+this.getName()+" "+this.getAddress()+" "+this.getEmail()+" "+this.getPin();//+" "+this.getAccounts();
        return str;
    }
    public void addAccountToCustomer(Accounts account){
        (this.accountsList).add(account);
        System.out.println("added a new account for customer");
        
    }
//    public String printAllAccountDetails(){
//        String allAccDets="";
//        for(int i=0;i<accountsList.size();i++){
//            allAccDets=allAccDets+accountsList.get(i).printAccountDetails()+" ";
//        }
//        return allAccDets;
//    }
}
