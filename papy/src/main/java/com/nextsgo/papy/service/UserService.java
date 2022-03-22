package com.nextsgo.papy.service;
import com.nextsgo.common.entity.Result;
import com.nextsgo.papy.entity.User;
public interface UserService {	
	

	public Result<?> findAll() ;

	public Result<?> userAdd(User user);

	public Result<?> findUserById(Long id) ;

	public Result<?> login(String name, String pwd) ;

	public Result<?> userAccount(String name) ;
	
}
