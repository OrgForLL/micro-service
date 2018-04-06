package com.nextsgo.papy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_s_shopUser")
public class t_s_shopUser {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@NotNull(message = "店铺ID")
	@Column(name = "Shopid",  columnDefinition = "varchar(50) default '' not null comment '店铺ID' ")
	private String shopid;
	
	@NotNull(message = "用户ID")
	@Column(name = "userid",  columnDefinition = " varchar(50) default '' not null comment '用户ID' ")
	private String userid;
	
	@NotNull(message = "是否主帐号")
	@Column(name = "ispAccountNumber", columnDefinition = " tinyint default 0   not null comment '不可用'")
	private Boolean ispAccountNumber=false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		shopid = shopid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Boolean getIspAccountNumber() {
		return ispAccountNumber;
	}

	public void setIspAccountNumber(Boolean ispAccountNumber) {
		this.ispAccountNumber = ispAccountNumber;
	}

}
