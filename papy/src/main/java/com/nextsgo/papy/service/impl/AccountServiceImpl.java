package com.nextsgo.papy.service.impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nextsgo.common.entity.Result;
import com.nextsgo.papy.entity.Account;

import com.nextsgo.papy.enums.ErrorStatusEnum;
import com.nextsgo.papy.repository.AccountRepository;
import com.nextsgo.papy.service.AccountService;
import com.nextsgo.papy.utils.JpaUpdateTool;
import com.nextsgo.papy.utils.ResultUtilExt;
 

@Service
public class AccountServiceImpl implements  AccountService{	

	@Autowired
	private AccountRepository accountRepository;
	
	public Result<?> findByName(String name){
		return ResultUtilExt.success(accountRepository.findByName(name));
	}
	public Result<?> findAll(){
		return ResultUtilExt.success(accountRepository.findAll());
	}	

	public Result<?> accountAdd( Account account) {
		try {
			if (null != account.getId()) {
				Account accountSrc=accountRepository.findById(account.getId());				
				if (null != accountSrc) {					
					JpaUpdateTool.copyNullProperties(accountSrc, account);
					return ResultUtilExt.success(accountRepository.save(account));
				}else {
					return ResultUtilExt.error(ErrorStatusEnum.accountId);
				}
			} else {
				if(null != accountRepository.findByName(account.getName()))
					return ResultUtilExt.error(ErrorStatusEnum.accountNameIsExit);
				return ResultUtilExt.success(accountRepository.save(account));
			}
			 
		} catch (Exception e) {
			return ResultUtilExt.error(ErrorStatusEnum.accountError, e.getMessage());
		}
	}
	
	
}
