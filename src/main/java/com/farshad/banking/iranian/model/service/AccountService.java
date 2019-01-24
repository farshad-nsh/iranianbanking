package com.farshad.banking.iranian.model.service;

import com.farshad.banking.iranian.model.domain.DollarAccount;
import com.farshad.banking.iranian.model.domain.RialAccount;

public interface AccountService {

    RialAccount createRialAccount(RialAccount rialAccount);

    DollarAccount createDollarAccount(DollarAccount dollarAccount);

    void deposit(String accountType, double amount);

    void withdraw(String accountType, double amount);

}
