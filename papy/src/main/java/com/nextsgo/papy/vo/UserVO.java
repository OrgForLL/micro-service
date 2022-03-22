package com.nextsgo.papy.vo;

import com.nextsgo.papy.entity.User;

import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * 用户
 * @author min
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserVO extends User {	
	private String token;	
}
