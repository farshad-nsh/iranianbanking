package com.farshad.banking.iranian.model.dao;

import com.farshad.banking.iranian.model.domain.DollarAccount;
import com.farshad.banking.iranian.model.domain.RialAccount;
import org.springframework.data.repository.CrudRepository;

public interface DollarAccountDao extends CrudRepository<DollarAccount,Long> {
    DollarAccount findDollarAccountByAccount(String account);

}
