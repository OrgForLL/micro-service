package com.nextsgo.papy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.papy.entity.Result;
import com.nextsgo.papy.entity.User;
import com.nextsgo.papy.repository.UserRepository;
import com.nextsgo.papy.utils.MD5Utils;
import com.nextsgo.papy.utils.ResultUtil;
@RestController
public class LoginController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping(value = "/login")
	private Result<?> login(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (null == name || name.length() == 0) {
			return ResultUtil.error(500, "require  name");
		}
		if (null == password || password.length() == 0) {
			return ResultUtil.error(501, "require  password");
		}
		List<User> listUser = userRepository.findByNameAndPassword(name, MD5Utils.getPwd(password));
		if (listUser.size() > 1) {
			return ResultUtil.error(300, "no unique user");
		} else if (listUser.size() == 0) {
			return ResultUtil.error(400, "no user");
		} else {
			return ResultUtil.success(listUser.get(0));
		}
	}
}
