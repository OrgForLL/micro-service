package com.nextsgo.msg.service;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import com.nextsgo.msg.entity.Message;
import com.nextsgo.msg.entity.Result;
import com.nextsgo.msg.tools.HttpRequest;


@Component
public class KafkaReceiver {
	@KafkaListener(topics = { "longPollingData" })
	public void listen(ConsumerRecord<?, ?> record) {
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			Message msg = JSON.parseObject(message.toString(), Message.class);
			Result<?> result =HttpRequest.post(msg.getUrl(), JSON.toJSONString(msg));
			
			System.out.println(result.getData());
		}
	}

}
