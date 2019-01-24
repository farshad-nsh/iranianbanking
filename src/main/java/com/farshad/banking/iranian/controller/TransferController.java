package com.farshad.banking.iranian.controller;

import com.farshad.banking.iranian.model.domain.Account;
import com.farshad.banking.iranian.model.domain.DollarAccount;
import com.farshad.banking.iranian.model.domain.RialTransaction;
import com.farshad.banking.iranian.model.service.AccountService;
import com.farshad.banking.iranian.model.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    TransactionService transactionService;

    @RequestMapping(method = RequestMethod.POST,consumes = APPLICATION_JSON_VALUE,
            value = "/saveRialDepositTransaction", produces = APPLICATION_JSON_VALUE)
    private void saveRialDepositTransaction(@RequestBody String username,@RequestBody RialTransaction rialTransaction) throws InterruptedException {
        transactionService.saveRialDepositTransaction(username,rialTransaction);
    }

}
