package com.farshad.banking.iranian;

import com.farshad.banking.iranian.model.domain.Account;
import com.farshad.banking.iranian.model.domain.BankUser;
import com.farshad.banking.iranian.model.domain.RialAccount;
import com.farshad.banking.iranian.model.domain.RialTransaction;
import com.farshad.banking.iranian.model.service.AccountService;
import com.farshad.banking.iranian.model.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author farshad noravesh
 */

@SpringBootApplication
public class OnlineBankingApplication {

    @Autowired
    BankUserService bankUserService;

    @Autowired
    AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(OnlineBankingApplication.class, args);
    }

    @Transactional
    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            System.out.println("iranian banking is enjoyable!");

            BankUser bankUser=new BankUser();
            bankUser.setUsername("farshad_no");
            System.out.println("bankUser.getUsername()="+bankUser.getUsername());
            RialTransaction rialTransaction=new RialTransaction();
            rialTransaction.setAmount(BigDecimal.valueOf(100));

            RialAccount rialAccount=new RialAccount();
            rialAccount.setAccount("2A-54-Iran-4646-4jh6C");
            rialAccount.getRialTransactionList().add(rialTransaction);
            accountService.createRialAccount(rialAccount);

            bankUser.setAccount(rialAccount);
            bankUserService.save(bankUser);

       };
    }

}
