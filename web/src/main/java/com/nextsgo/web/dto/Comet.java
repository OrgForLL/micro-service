package com.nextsgo.web.dto;

import lombok.Data;

@Data
public class Comet {
	private String longPollingUrl;
	private String topic;
	private String kafkaSender;
}
