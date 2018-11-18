package com.nextsgo.msg.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.nextsgo.msg.entity.Message;


@Component
@Service
public class KafkaSender {
	 @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;
	    
	    //发送消息方法
	    public void send(Message message) {
	        kafkaTemplate.send(message.getTopic(), JSON.toJSONString(message) );
	    }
	 
}
