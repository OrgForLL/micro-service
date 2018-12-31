package com.nextsgo.web.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.nextsgo.common.entity.Message;
import com.nextsgo.common.entity.Result;
import com.nextsgo.common.tools.HttpRequest;
import com.nextsgo.common.tools.ResultUtil;
import com.nextsgo.web.dto.SoftConfig;
@RestController
public class WebApi {
	@Autowired
	private SoftConfig softConfig;
	
	@GetMapping(value = "/test")
	public Result<?> login(HttpServletRequest request) {
		return ResultUtil.success("test");
	}
	
	@PostMapping(value = "/send")
	public Result<?> send(@RequestParam String to,@RequestParam String msg) {
		Message message=new Message();
		message.setMsg(msg);
		message.setTo(to);
		message.setUrl(softConfig.getComet().getLongPollingUrl());
		message.setTopic(softConfig.getComet().getTopic());
		return HttpRequest.post(softConfig.getComet().getKafkaSender(), JSON.toJSONString(message));		
	}
}
