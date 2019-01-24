package com.farshad.banking.iranian.model.service.ServiceImpl;


import com.farshad.banking.iranian.model.dao.DollarAccountDao;
import com.farshad.banking.iranian.model.dao.RialAccountDao;
import com.farshad.banking.iranian.model.domain.*;
import com.farshad.banking.iranian.model.service.BankUserService;
import com.farshad.banking.iranian.model.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @author farshad noravesh
 * @version 1.0.0
 */
@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    BankUserService bankUserService;

    @Autowired
    RialAccountDao rialAccountDao;

    @Autowired
    DollarAccountDao dollarAccountDao;


    @Override
    public List<DollarTransaction> findDollarTransactionList(String username) {
    DollarAccount dollarAccount= (DollarAccount) bankUserService.findByUsername(username).getAccount();
    List<DollarTransaction> dollarTransactionList=dollarAccount.getDollarTransactionList();

        return dollarTransactionList;
    }

    @Override
    public List<RialTransaction> findRialTransactionList(String username) {
        RialAccount rialAccount= (RialAccount) bankUserService.findByUsername(username).getAccount();
        List<RialTransaction> rialTransactionList=rialAccount.getRialTransactionList();
        return rialTransactionList;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveRialDepositTransaction(String username,RialTransaction rialTransaction) {
        BankUser bankUser=bankUserService.findByUsername(username);
        RialAccount rialAccount=rialAccountDao.findById(bankUser.getId()).get();
        rialAccount.getRialTransactionList().add(rialTransaction);
        rialAccount.setAccountBalance(rialAccount.getAccountBalance()+
                rialTransaction.getAmount().longValue());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveDollarDepositTransaction(String username,DollarTransaction dollarTransaction) {
        BankUser bankUser=bankUserService.findByUsername(username);
        DollarAccount dollarAccount=dollarAccountDao.findById(bankUser.getId()).get();
        dollarAccount.getDollarTransactionList().add(dollarTransaction);
        dollarAccount.setAccountBalance(dollarAccount.getAccountBalance().longValue()+
                dollarTransaction.getAmount().longValue());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveRialWithdrawTransaction(String username,RialTransaction rialTransaction) {
        BankUser bankUser=bankUserService.findByUsername(username);
        RialAccount rialAccount=rialAccountDao.findById(bankUser.getId()).get();
        rialAccount.getRialTransactionList().add(rialTransaction);
        rialAccount.setAccountBalance(rialAccount.getAccountBalance()-
                rialTransaction.getAmount().longValue());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveDollarWithdrawTransaction(String username,DollarTransaction dollarTransaction) {
        BankUser bankUser=bankUserService.findByUsername(username);
        DollarAccount dollarAccount=dollarAccountDao.findById(bankUser.getId()).get();
        dollarAccount.getDollarTransactionList().add(dollarTransaction);
        dollarAccount.setAccountBalance(dollarAccount.getAccountBalance().longValue()-
                dollarTransaction.getAmount().longValue());
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void betweenAccountsTransfer(String transferFrom, String transferTo, Long amount,String type) throws Exception {
        if (type=="rial"){
            RialAccount fromRialAccount=rialAccountDao.findRialAccountByAccount(transferFrom);
            RialAccount toRialAccount=rialAccountDao.findRialAccountByAccount(transferTo);
            fromRialAccount.setAccountBalance(fromRialAccount.getAccountBalance()-amount);
            toRialAccount.setAccountBalance(toRialAccount.getAccountBalance()+amount);

        }else if(type=="dollar"){
            DollarAccount fromDollarAccount=dollarAccountDao.findDollarAccountByAccount(transferFrom);
            DollarAccount toDollarAccount=dollarAccountDao.findDollarAccountByAccount(transferTo);
            fromDollarAccount.setAccountBalance(fromDollarAccount.getAccountBalance().longValue()-amount);
            toDollarAccount.setAccountBalance(toDollarAccount.getAccountBalance().longValue()+amount);

        }

    }


}
