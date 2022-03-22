package com.nextsgo.papy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.common.entity.Result;
import com.nextsgo.papy.entity.Menu;
import com.nextsgo.papy.entity.User;
import com.nextsgo.papy.enums.ErrorStatusEnum;
import com.nextsgo.papy.jwt.CheckToken;
import com.nextsgo.papy.jwt.LoginToken;
import com.nextsgo.papy.service.MenuService;
import com.nextsgo.papy.service.UserService;
import com.nextsgo.papy.utils.ResultUtilExt;

/***
 * 用户处理
 * 
 * @author min
 *
 */
@RestController
public class MenuController extends BaseController {

	@Autowired
	MenuService menuService;

	@CheckToken
	@GetMapping(value = "/menus")
	private Result<?> menusList() {	 
		return  menuService.findAll();		 
	}
	
	@CheckToken
	@PostMapping(value = "/menu")
	private Result<?> menuAdd(@Valid Menu menu, BindingResult bindingResult) {
		//更新不判断有效性，部份更新
		if (null == menu.getId() && bindingResult.hasErrors()) {
			return ResultUtilExt.error(ErrorStatusEnum.menuError,
					bindingResult.getFieldError().getDefaultMessage());
		}
		return menuService.menuAdd(menu);
	}
	
}
