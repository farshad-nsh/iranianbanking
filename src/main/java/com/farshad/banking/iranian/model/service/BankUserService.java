package com.farshad.banking.iranian.model.service;

import com.farshad.banking.iranian.model.domain.BankUser;

import java.util.List;

public interface BankUserService {
    BankUser findByUsername(String username);
    BankUser findByEmail(String email);

    boolean checkUserExists(String username, String email);
    boolean checkUsernameExists(String username);
    boolean checkEmailExists(String email);

    void save(BankUser bankUser);
    BankUser createUser(BankUser bankUser);
    BankUser saveUser(BankUser bankUser);

    List<BankUser> findUserList();

    void enableUser (String username);

    void disableUser (String username);
}
