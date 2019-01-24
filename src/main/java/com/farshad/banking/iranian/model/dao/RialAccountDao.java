package com.farshad.banking.iranian.model.dao;

import com.farshad.banking.iranian.model.domain.RialAccount;
import org.springframework.data.repository.CrudRepository;

public interface RialAccountDao extends CrudRepository<RialAccount,Long>{
      RialAccount findRialAccountByAccount(String account);
}
