package com.nextsgo.web.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "soft")
public class SoftConfig {
	private Comet comet;
}
