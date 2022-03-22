package com.nextsgo.papy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.common.entity.Result;
import com.nextsgo.papy.entity.User;
import com.nextsgo.papy.enums.ErrorStatusEnum;
import com.nextsgo.papy.jwt.CheckToken;
import com.nextsgo.papy.jwt.LoginToken;
import com.nextsgo.papy.service.UserService;
import com.nextsgo.papy.utils.ResultUtilExt;

/***
 * 用户处理
 * 
 * @author min
 *
 */
@RestController
public class UserController extends BaseController {

	@Autowired
	UserService userService;

	@CheckToken
	@GetMapping(value = "/users")
	private Result<?> usersList() {	 
		return  userService.findAll();		 
	}
	
	@CheckToken
	@PostMapping(value = "/user")
	private Result<?> userAdd(@Valid User user, BindingResult bindingResult) {
		//更新不判断有效性，部份更新
		if (null == user.getId() && bindingResult.hasErrors()) {
			return ResultUtilExt.error(ErrorStatusEnum.userError,
					bindingResult.getFieldError().getDefaultMessage());
		}
		return userService.userAdd(user);		 
	}
	
	@LoginToken
	@GetMapping(value = "/login/{pwd}/{name}")
	private Result<?> login(@PathVariable("pwd") String pwd, @PathVariable("name") String name) {	 
		return  userService.login(name, pwd);		 		 
	}
	@CheckToken
	@GetMapping(value = "/userAccount/{name}")
	private Result<?> userAccount( @PathVariable("name") String name) {	 
		return  userService.userAccount(name);
	}
	/***
	 * 使用SQL语句查询
	 * 
	 * @param name
	 * @return
	 */
	/***
	 * @GetMapping(value = "/likename") public Result<?>
	 *                   findContactsUseDyanamicQueryLikeName(String name) { String
	 *                   nameWhere = org.apache.commons.lang.StringUtils.join(new
	 *                   String[] { "%", name, "%" }, ""); List<T_S_USER> contacts =
	 *                   userService.findAllByViaQuery(nameWhere); if (contacts ==
	 *                   null) { return ResultUtil.error(1, "empty data"); } else {
	 *                   return ResultUtil.success(contacts); } }
	 */
	/***
	 * 使用SQL语句查询
	 * 
	 * @return
	 */
	// @Autowired
	// private NativeQuery nativeQuery;
	// @PostMapping(value = "/test")
	// public Result<?> testJpa() {
	// return ResultUtil.success(nativeQuery.getResultList("Select * from user"));
	// }
}
