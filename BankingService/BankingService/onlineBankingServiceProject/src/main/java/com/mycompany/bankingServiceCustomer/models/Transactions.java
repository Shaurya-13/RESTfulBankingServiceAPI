/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bankingServiceCustomer.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author shaug
 */
public class Transactions {
    private int id;
    private String transactionType;
    private String date; 
    private String description;
    private double postAccountBalance;
    private int transactionAmount;
    private String transactionKeyword;
    
    public Transactions(){}
   
    public Transactions(int id,String accountType, String date,String description,double accountBalance,int transactionAmount,String transactionKeyword){
        this.id=id;
        this.transactionType=accountType;
        this.date=date; 
        this.postAccountBalance=accountBalance;
        this.description=description;
        this.transactionAmount=transactionAmount;
        this.transactionKeyword=transactionKeyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionKeyword() {
        return transactionKeyword;
    }

    public void setTransactionKeyword(String transactionKeyword) {
        this.transactionKeyword = transactionKeyword;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
     public double getPostAccountBalance() {
        return postAccountBalance;
    }

    public void setPostAccountBalance(double postAccountBalance) {
        this.postAccountBalance = postAccountBalance;
    }
    public String printTransactionDetails() {
        String str = this.getId()+" "+this.getTransactionType()+" "+this.getDate()+" "+this.getDescription()+" "+" "+this.getPostAccountBalance()+" "+this.getTransactionAmount()+" "+this.getTransactionKeyword(); 
        return str;
    }
}
