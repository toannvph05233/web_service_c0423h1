package com.web_service_c0423h1.repository;

import com.web_service_c0423h1.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
}
