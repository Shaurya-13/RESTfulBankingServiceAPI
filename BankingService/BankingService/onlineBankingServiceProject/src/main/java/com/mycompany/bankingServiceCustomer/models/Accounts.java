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
public class Accounts {
    private int id;
    private String sortCode;
    private String accountNumber;
    private double initialAccountBalance;
    private String accountType;
    private double currentAccountBalance;
    private List<Transactions>transactionsList=new ArrayList<>();
    public Accounts(){}
    
    public Accounts(int id,String sortCode,String accountNumber,double accountBalance,String accountType){
        this.id=id;
        this.sortCode=sortCode;
        this.accountNumber=accountNumber;
        this.initialAccountBalance=accountBalance;
        this.accountType=accountType;
    }
    public Accounts(int id,String sortCode,String accountNumber,double accountBalance,String accountType, List<Transactions>transactionsList,double currentAccountBalance){
        this.id=id;
        this.sortCode=sortCode;
        this.accountNumber=accountNumber;
        this.initialAccountBalance=accountBalance;
        this.accountType=accountType;
        this.transactionsList=transactionsList;
        this.currentAccountBalance=currentAccountBalance;
    }

    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public void setCurrentAccountBalance(double currentAccountBalance) {
        this.currentAccountBalance = currentAccountBalance;
    }

    public int getId() {
        return id;
    }

    public List<Transactions> getTransactions() {
        return transactionsList;
    }

    public void setTransactions(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getInitialAccountBalance() {
        return initialAccountBalance;
    }

    public void setInitialAccountBalance(double initialAccountBalance) {
        this.initialAccountBalance = initialAccountBalance;
    }
        public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String printAccountDetails() {
        String str = this.getId()+" "+this.getSortCode()+" "+this.getAccountNumber()+" "+this.getInitialAccountBalance()+" "+this.getAccountType();
        return str;
    }
    public void addTransactionToAccount(Transactions transaction){
        (this.transactionsList).add(transaction);
        System.out.println("added a new transaction for account");
        
    }
}
