package com.farshad.banking.iranian.model.dao;

import com.farshad.banking.iranian.model.domain.BankUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BankUserDao extends CrudRepository<BankUser,Long> {
    BankUser findByUsername(String username);
    BankUser findByEmail(String email);
    List<BankUser> findAll();
}
