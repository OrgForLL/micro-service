package com.nextsgo.papy.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/***
 * 配置文件
 * @author min
 *
 */
@Component
@ConfigurationProperties(prefix = "JWT")
public class JwtProperties {
	private  String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}	
}
