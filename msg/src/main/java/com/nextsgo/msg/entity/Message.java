package com.nextsgo.msg.entity;

import lombok.Data;

@Data
public class Message {
	private String to;    //id

    private String msg; //消息

    private String url;
    private String topic;
}
