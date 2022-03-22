package com.nextsgo.papy.service;


import com.nextsgo.common.entity.Result;
import com.nextsgo.papy.entity.Menu;

public interface MenuService {

	public Result<?> findAll() ;

	public Result<?> menuAdd(Menu menu) ;

	public Result<?> findMenuById(Long id) ;

 
}
