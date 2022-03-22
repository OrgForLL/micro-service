package com.nextsgo.papy.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nextsgo.papy.entity.Account;
import com.nextsgo.papy.entity.User;

 

public interface AccountRepository extends  JpaRepository<Account,Long> {   
	Account findByName(String name);
	Account findById(Long id);
}