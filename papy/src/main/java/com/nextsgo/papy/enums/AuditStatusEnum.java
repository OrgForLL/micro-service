package com.nextsgo.papy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditStatusEnum {
	audited(1, "已审核"),
	unaudit(0, "未审核"),
	auditing(3, "审核中");
	private Integer value;
	private String desc;
}

