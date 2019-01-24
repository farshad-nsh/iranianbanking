package com.farshad.banking.iranian.model.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "RialAccount_ID")
public class RialAccount extends Account {

    private String account;

    private long accountBalance;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.UpdateTimestamp
    private Date lastUpdateTime;


    @ElementCollection
    @CollectionTable(name = "rial_transaction")
    @Column(name = "rial_transaction_name")
   // @OrderColumn(name = "order")
    private List<RialTransaction> rialTransactionList=new ArrayList<RialTransaction>();

    public List<RialTransaction> getRialTransactionList() {
        return rialTransactionList;
    }

    public void setRialTransactionList(List<RialTransaction> rialTransactionList) {
        this.rialTransactionList = rialTransactionList;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }
}
