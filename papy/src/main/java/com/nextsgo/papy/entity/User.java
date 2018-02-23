package com.nextsgo.papy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.SqlResultSetMapping;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.FieldResult;

@Entity
@Table(name = "user")
@SqlResultSetMapping(name = "userMapping", entities = @EntityResult(entityClass = User.class, fields = {
		@FieldResult(name = "id", column = "id"), 
		@FieldResult(name = "name", column = "name"),
		@FieldResult(name = "fullName", column = "full_name"),
		@FieldResult(name = "password", column = "pass_word"),
		@FieldResult(name = "createDate", column = "create_date"),
		@FieldResult(name = "createorID", column = "createor_id"),
		@FieldResult(name = "modifier", column = "modifier"),
		@FieldResult(name = "verifier", column = "verifier"),
		@FieldResult(name = "disabled", column = "disabled")
		
		
}))
public class User {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String  id;

	@NotNull(message = "用户名必传")
	@Column(name = "name", unique = true, columnDefinition = " varchar(50) default '' not null  comment '用户名' ")
	private String name;

	@NotNull(message = "密码必传")
	@Column(name = "pass_word", columnDefinition = " varchar(500) default '' not null comment '登陆密码' ")
	private String password;

	@NotNull(message = "中文名必传")
	@Column(name = "full_name", unique = true, columnDefinition = " varchar(500) default '' not null comment '中文名' ")
	private String fullName;

	
	@Column(name = "modifier", columnDefinition = " varchar(50) default '' not null   comment '修改人'")
	private String modifier="";
	
	@Column(name = "verifier", columnDefinition = " varchar(50) default ''  not null comment '确认人'")
	private String verifier="";	
	
	
	
	/*常用*/
	@Column(name = "is_disabled", columnDefinition = " tinyint default 0   not null comment '不可用'")
	private Boolean isDisabled=false;
	
	@Column(name = "remark", columnDefinition = " varchar(500) default ''  not null comment '备注'")
	private String remark="";
	
	@Column(name = "create_date", columnDefinition = " datetime comment '创建日期'")
	private java.util.Date createDate;
	
	@Column(name = "createor_id", columnDefinition = " varchar(36) default ''  not null comment '创建人'")
	private String createorId="";
	/*常用end*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getVerifier() {
		return verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public Boolean getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateorId() {
		return createorId;
	}

	public void setCreateorId(String createorId) {
		this.createorId = createorId;
	}

	

	 

}
