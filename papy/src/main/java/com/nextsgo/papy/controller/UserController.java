package com.nextsgo.papy.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.papy.entity.Result;
import com.nextsgo.papy.entity.T_S_USER;
import com.nextsgo.papy.repository.UserRepository;
import com.nextsgo.papy.service.UserService;
import com.nextsgo.papy.utils.MD5Utils;
import com.nextsgo.papy.utils.ManInfoProperties;
import com.nextsgo.papy.utils.NativeQuery;
import com.nextsgo.papy.utils.ResultUtil;
/***
 * 用户处理
 * @author min
 *
 */
@RestController
public class UserController extends BaseController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/users")
	private Result<?> usersList() {
		try {
			return ResultUtil.success(userRepository.findAll());

		} catch (Exception e) {
			return ResultUtil.error(100, e.getMessage());
		}

	}

	/*@PostMapping(value = "/users")
	private Result<?> userAdd(@Valid T_S_USER user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		user.setPassword(MD5Utils.getPwd(user.getPassword()));
		
		try {
			if (null != userRepository.findbycode(user.getCode())) {
				return ResultUtil.error(100, "用户名已存在");
			} else if (null != userRepository.findByFullcode(user.getNameEn())) {
				return ResultUtil.error(100, "中文名已存在");
			} else {
				return ResultUtil.success(userRepository.save(user));
			}
		} catch (Exception e) {
			return ResultUtil.error(100, e.getMessage());
		}

	}*/
	
	/***
	 * 使用SQL语句查询
	 * 
	 * @param name
	 * @return
	 */
	/***@GetMapping(value = "/likename")
	public Result<?> findContactsUseDyanamicQueryLikeName(String name) {
		String nameWhere = org.apache.commons.lang.StringUtils.join(new String[] { "%", name, "%" }, "");
		List<T_S_USER> contacts = userService.findAllByViaQuery(nameWhere);
		if (contacts == null) {
			return ResultUtil.error(1, "empty data");
		} else {
			return ResultUtil.success(contacts);
		}
	} */
	/***
	 * 使用SQL语句查询
	 * 
	 * @return
	 */
	@Autowired
	private NativeQuery nativeQuery;
	@PostMapping(value = "/test")
	public Result<?> testJpa() {		
		return ResultUtil.success(nativeQuery.getResultList("Select * from user"));
	}
}
