package com.nextsgo.msg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.nextsgo.msg.entity.Message;
import com.nextsgo.msg.entity.Result;
import com.nextsgo.msg.service.KafkaSender;
import com.nextsgo.msg.tools.ResultUtil;



@RestController
public class Kafka {
	@Autowired
	private KafkaSender kafkaSender;
	
	
	@RequestMapping("/Send")
	@ResponseBody
	private Result<?> Send(@RequestBody Message message) {			
		kafkaSender.send(message);
		return ResultUtil.success();
	}
}
