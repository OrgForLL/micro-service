package com.nextsgo.papy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "T_S_USER")
public class T_S_USER {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@NotNull(message = "帐号")
	@Column(name = "code",columnDefinition = " varchar(50) default '' not null comment '帐号' ")
	private String code;
	
	@NotNull(message = "手机号")
	@Column(name = "Mobile", columnDefinition = " varchar(50) default '' not null comment '手机号' ")
	private String mobile;
	
	@NotNull(message = "昵称")
	@Column(name = "nameEn",  columnDefinition = " varchar(50) default '' not null comment '昵称' ")
	private String nameEn;
	
	@NotNull(message = "密码")
	@Column(name = "PassWord", columnDefinition = " varchar(50) default '' not null comment '密码' ")
	private String password;
	 
	@NotNull(message = "性别")
	@Column(name = "sexID", columnDefinition = " varchar(50) default '' comment '性别' ")
	private String sexID;
	
	@NotNull(message = "公历")
	@Column(name = "isGregorian",  columnDefinition = " tinyint default 0  comment '公历' ")
	private Boolean isGregorian=true;
		
	@Column(name = "birthday", columnDefinition = " datetime comment '生日'")
	private java.util.Date birthday;
	/*常用*/
	@Column(name = "is_disabled", columnDefinition = " tinyint default 0   not null comment '不可用'")
	private Boolean isDisabled=false;
		
	@Column(name = "create_date", columnDefinition = " datetime comment '创建日期'")
	private java.util.Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexID() {
		return sexID;
	}

	public void setSexID(String sexID) {
		this.sexID = sexID;
	}

	public Boolean getIsGregorian() {
		return isGregorian;
	}

	public void setIsGregorian(Boolean isGregorian) {
		this.isGregorian = isGregorian;
	}

	public java.util.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(Boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	public java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	
}
