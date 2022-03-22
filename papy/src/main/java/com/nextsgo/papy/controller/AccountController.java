package com.nextsgo.papy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.common.entity.Result;
import com.nextsgo.common.tools.ResultUtil;
import com.nextsgo.papy.entity.Account;
import com.nextsgo.papy.entity.User;
import com.nextsgo.papy.enums.ErrorStatusEnum;
import com.nextsgo.papy.service.AccountService;
import com.nextsgo.papy.service.UserService;
import com.nextsgo.papy.utils.ResultUtilExt;



/***
 * 用户处理
 * @author min
 *
 */
@RestController
public class AccountController extends BaseController {

	@Autowired
	AccountService accountService;
	
	@GetMapping(value = "/account")
	private Result<?> accountList() {		
		return accountService.findAll();	
	}
	@GetMapping(value = "/account/{name}")
	private Result<?> account(@PathVariable("name") String name) {
		return accountService.findByName(name);
	}
	
	@PostMapping(value = "/account")
	private Result<?> accountAdd(@Valid Account account, BindingResult bindingResult) {
		//修改不提示，可以部份修改
		if ( null ==account.getId() && bindingResult.hasErrors()) {
			return ResultUtilExt.error(ErrorStatusEnum.accountError, bindingResult.getFieldError().getDefaultMessage());
		}		 
		return accountService.accountAdd(account);		 
	}
	
	 
}
