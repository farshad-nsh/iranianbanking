package com.farshad.banking.iranian.model.service;

import com.farshad.banking.iranian.model.domain.*;

import java.util.List;

public interface TransactionService {

    List<DollarTransaction> findDollarTransactionList(String username);

    List<RialTransaction> findRialTransactionList(String username);

    void saveRialDepositTransaction(String username,RialTransaction rialTransaction);

    void saveDollarDepositTransaction(String username,DollarTransaction dollarTransaction);

    void saveRialWithdrawTransaction(String username,RialTransaction rialTransaction);

    void saveDollarWithdrawTransaction(String username,DollarTransaction dollarTransaction);

    void betweenAccountsTransfer(String transferFrom, String transferTo, Long amount,String type) throws Exception;



}
