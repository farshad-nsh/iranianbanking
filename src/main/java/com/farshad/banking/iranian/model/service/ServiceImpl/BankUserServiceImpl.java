package com.farshad.banking.iranian.model.service.ServiceImpl;

import com.farshad.banking.iranian.model.dao.BankUserDao;
import com.farshad.banking.iranian.model.domain.BankUser;
import com.farshad.banking.iranian.model.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankUserServiceImpl implements BankUserService {

   @Autowired
    BankUserDao bankUserDao;

    @Override
    public BankUser findByUsername(String username) {
       return bankUserDao.findByUsername(username);
    }

    @Override
    public BankUser findByEmail(String email) {
        return null;
    }

    @Override
    public boolean checkUserExists(String username, String email) {
        return false;
    }

    @Override
    public boolean checkUsernameExists(String username) {
        return false;
    }

    @Override
    public boolean checkEmailExists(String email) {
        return false;
    }

    @Override
    public void save(BankUser bankUser) {
       bankUserDao.save(bankUser);
    }

    @Override
    public BankUser createUser(BankUser bankUser) {
        return null;
    }

    @Override
    public BankUser saveUser(BankUser bankUser) {
        return null;
    }

    @Override
    public List<BankUser> findUserList() {
        return null;
    }

    @Override
    public void enableUser(String username) {

    }

    @Override
    public void disableUser(String username) {

    }
}
