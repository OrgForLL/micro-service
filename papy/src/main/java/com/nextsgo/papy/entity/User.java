package com.nextsgo.papy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	@NotNull (message = "用户名必传")
	@Column(name = "name",columnDefinition="用户名")
	private String name;
	
	@Column(name = "pass_word",columnDefinition="登陆密码")
	private String password;
	
	@NotNull (message = "中文名必传")
	@Column(name = "full_name",columnDefinition="中文名")
	private String fullName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWord() {
		return password;
	}

	public void setPassWord(String passWord) {
		this.password = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
