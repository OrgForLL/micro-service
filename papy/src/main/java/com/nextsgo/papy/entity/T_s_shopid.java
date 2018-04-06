package com.nextsgo.papy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_s_shopid")
public class T_s_shopid {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@NotNull(message = "名称")
	@Column(name = "Name",  columnDefinition = " varchar(50) default '' not null comment '名称' ")
	private String name;
	
	@NotNull(message = "省份")
	@Column(name = "ProvinceID", columnDefinition = " varchar(50) default '' null comment '省份' ")
	private String provinceID;
	
	@NotNull(message = "城市")
	@Column(name = "cityID",  columnDefinition = " varchar(50) default '' null comment '城市' ")
	private String cityID;
	
	@NotNull(message = "区/县")
	@Column(name = "towerID",columnDefinition = " varchar(50) default '' null comment '区/县' ")
	private String towerID;	
	
	@NotNull(message = "详细地址")
	@Column(name = "address", columnDefinition = "  varchar(250) default '' null comment '详细地址' ")
	private String address;
	
	@NotNull(message = "联系人")
	@Column(name = "Contacts",columnDefinition = " varchar(50) default '' null comment '联系人' ")
	private String contacts;
	
	@NotNull(message = "手机号码")
	@Column(name = "mobile",  columnDefinition = "  varchar(50) default '' null comment '手机号码' ")
	private String mobile;
	
	@NotNull(message = "联系电话")
	@Column(name = "Tel",columnDefinition = "  varchar(50) default '' null comment '联系电话' ")
	private String tel;

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

	public String getProvinceID() {
		return provinceID;
	}

	public void setProvinceID(String provinceID) {
		this.provinceID = provinceID;
	}

	public String getCityID() {
		return cityID;
	}

	public void setCityID(String cityID) {
		this.cityID = cityID;
	}

	public String getTowerID() {
		return towerID;
	}

	public void setTowerID(String towerID) {
		this.towerID = towerID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	
}
