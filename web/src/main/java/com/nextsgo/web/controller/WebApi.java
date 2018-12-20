package com.nextsgo.web.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextsgo.common.entity.Result;
import com.nextsgo.common.tools.ResultUtil;
@RestController
public class WebApi {
	@GetMapping(value = "/test")
	private Result<?> login(HttpServletRequest request) {
		return ResultUtil.success("test");
	}
}
