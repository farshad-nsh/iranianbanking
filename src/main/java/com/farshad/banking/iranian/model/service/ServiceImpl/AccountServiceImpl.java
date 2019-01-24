package com.farshad.banking.iranian.model.service.ServiceImpl;

import com.farshad.banking.iranian.model.dao.DollarAccountDao;
import com.farshad.banking.iranian.model.dao.RialAccountDao;
import com.farshad.banking.iranian.model.domain.DollarAccount;
import com.farshad.banking.iranian.model.domain.RialAccount;
import com.farshad.banking.iranian.model.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    DollarAccountDao dollarAccountDao;

    @Autowired
    RialAccountDao rialAccountDao;

    @Override
    public RialAccount createRialAccount(RialAccount rialAccount) {
        return rialAccountDao.save(rialAccount);
    }

    @Override
    public DollarAccount createDollarAccount(DollarAccount dollarAccount) {
        return dollarAccountDao.save(dollarAccount);
    }

    @Override
    public void deposit(String accountType, double amount) {

    }

    @Override
    public void withdraw(String accountType, double amount) {

    }
}
