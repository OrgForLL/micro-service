package com.nextsgo.papy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer")
public class Customer {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@NotNull(message = "客户编号必传")
	@Column(name = "number", unique = true, columnDefinition = " varchar(50) default '' not null comment '客户编号' ")
	private String number;
	
	@NotNull(message = "客户名必传")
	@Column(name = "name", unique = true, columnDefinition = " varchar(500) default '' not null comment '客户名' ")	
	private String name;
	
	@Column(name = "tel", columnDefinition = " varchar(50) default '' not null comment '电话号码' ")
	private String tel="";

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

