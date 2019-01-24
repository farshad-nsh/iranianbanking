package com.farshad.banking.iranian.model.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "DollarAccount_ID")
public class DollarAccount extends Account {

    private String account;

    private BigDecimal accountBalance;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.UpdateTimestamp
    private Date lastUpdateTime;


    @ElementCollection
    @CollectionTable(name = "dollar_transaction")
    @Column(name = "dollar_transaction_name")
    //@OrderColumn(name = "order")
    private List<DollarTransaction> dollarTransactionList=new ArrayList<DollarTransaction>();

    public List<DollarTransaction> getDollarTransactionList() {
        return dollarTransactionList;
    }

    public void setDollarTransactionList(List<DollarTransaction> dollarTransactionList) {
        this.dollarTransactionList = dollarTransactionList;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = BigDecimal.valueOf(accountBalance);
    }
}
