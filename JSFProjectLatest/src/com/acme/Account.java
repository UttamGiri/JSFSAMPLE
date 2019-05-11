package com.acme;

import java.io.Serializable;
import java.util.Date;


public class Account implements Serializable {

    private static final long serialVersionUID = 6703431418383613409L;
    private Long id;
    private String name;
    private Date lastTransactionDate;
    private Double balance;

    public Account(Long id, String name, Date lastTransactionDate,
            Double balance) {
        this.id = id;
        this.name = name;
        this.lastTransactionDate = lastTransactionDate;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(Date transactionDate) {
        this.lastTransactionDate = transactionDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
