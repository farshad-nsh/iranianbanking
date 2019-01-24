package com.farshad.banking.iranian.controller;


import com.farshad.banking.iranian.model.domain.Account;
import com.farshad.banking.iranian.model.domain.DollarAccount;
import com.farshad.banking.iranian.model.domain.RialAccount;
import com.farshad.banking.iranian.model.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.POST,consumes = APPLICATION_JSON_VALUE,
            value = "/registerDollarAccount", produces = APPLICATION_JSON_VALUE)
    private Account registerNewDollarAccount(@RequestBody DollarAccount dollarAccount) throws InterruptedException {
        accountService.createDollarAccount(dollarAccount);
        return dollarAccount;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = APPLICATION_JSON_VALUE,
            value = "/registerRialAccount", produces = APPLICATION_JSON_VALUE)
    private Account registerNewRialAccount(@RequestBody RialAccount rialAccount) throws InterruptedException {
        accountService.createRialAccount(rialAccount);
        return rialAccount;
    }
}
