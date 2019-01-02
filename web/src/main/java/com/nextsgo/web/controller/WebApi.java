package com.nextsgo.web.controller;

 

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
	
	@ResponseBody
	@RequestMapping(value = "/send", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public Result<?> send(@RequestBody JSONObject jsonParam/*@RequestParam String msg,@RequestParam String to*/) {
		String msg=jsonParam.getString("msg");
		String to=jsonParam.getString("to");
		Message message=new Message();
		message.setMsg(msg);
		message.setTo(to);
		message.setUrl(softConfig.getComet().getLongPollingUrl());
		message.setTopic(softConfig.getComet().getTopic());
		return HttpRequest.post(softConfig.getComet().getKafkaSender(), JSON.toJSONString(message));		
	}
}
