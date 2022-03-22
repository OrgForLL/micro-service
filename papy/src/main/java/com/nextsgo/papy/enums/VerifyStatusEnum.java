package com.nextsgo.papy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VerifyStatusEnum {
	verified(1, "已确认"),
	unverify(0, "未确认"),
	verifying(3, "确认中");
	private Integer value;
	private String desc;
}

