package com.farshad.banking.iranian.controller;

import com.farshad.banking.iranian.model.domain.BankUser;
import com.farshad.banking.iranian.model.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

public class UserController {


    @Autowired
    BankUserService bankUserService;

    @RequestMapping(method = RequestMethod.POST,consumes = APPLICATION_JSON_VALUE,
            value = "/registerNewUser", produces = APPLICATION_JSON_VALUE)
    private BankUser registerNewUser(@RequestBody BankUser bankUser) throws InterruptedException {
        bankUserService.save(bankUser);
        return bankUserService.findByUsername(bankUser.getUsername());
    }


}
