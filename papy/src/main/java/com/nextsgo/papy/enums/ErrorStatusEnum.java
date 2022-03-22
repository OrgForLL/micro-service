package com.nextsgo.papy.enums;

import com.alibaba.fastjson.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorStatusEnum {
	
	userError(4000, "用户信息错误"),
	userNameIsExit(4001, "用户名已存在"),	
	userFullNameIsExit(4002, "中文名已存在"),
	userNameOrPwd(4003, "用户名或密码不正确"),	
	userId(4004, "查无用户标识"),
	userInvalidName(4005, "查无此用户"),
	userInvalidPsw(4006, "密码不正确"),
	
	accountError(5000, "套账信息错误"),
	accountNameIsExit(5001, "套账名已存在"),
	accountId(5002, "查无套账名"),
	
	menuError(6000, "菜单信息错误"),
	menuId(6004, "查无菜单标识"),
	menuNameIsExit(6001, "菜单名已存在"),
	
	error(1000, "常规错误"),
	errorToken(1001, "身份验证失败"),
	errorAccessException(1002, "访问异常"),
	errorInvalidname(1003, "用户不存在，请重新登录"),
	errorIllegalAccess(1004, "非法访问"),
	errorExpiredJwt(1005, "登陆超时，请重新登陆")
	;
	private Integer code;
	private String msg;
	
	@Override 
	public String toString() {
		JSONObject json=new JSONObject();
		json.put("code", this.code);
		json.put("msg", this.msg);
		return json.toJSONString();
	}
}

