package com.nextsgo.msg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.nextsgo.msg.entity.Message;
 
import com.nextsgo.msg.service.KafkaSender;
import com.nextsgo.common.entity.Result;
import com.nextsgo.common.tools.ResultUtil;



@RestController
public class Kafka {
	@Autowired
	private KafkaSender kafkaSender;
	
	
	@RequestMapping("/send")
	@ResponseBody
	private Result<?> send(@RequestBody Message message) {			
		kafkaSender.send(message);
		System.out.println(message.getTo());
		return ResultUtil.success();
	}
}
