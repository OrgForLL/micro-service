package com.nextsgo.papy.service;
import com.nextsgo.common.entity.Result;
import com.nextsgo.papy.entity.Account;


public interface AccountService {
	public Result<?> findByName(String name);
	public Result<?> findAll();
	public Result<?> accountAdd( Account account) ;	
}
