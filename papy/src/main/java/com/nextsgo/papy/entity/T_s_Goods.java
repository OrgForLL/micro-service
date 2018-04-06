package com.nextsgo.papy.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_s_Goods")
public class T_s_Goods {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@NotNull(message = "款号")
	@Column(name = "Code",  columnDefinition = " varchar(50) default '' not null comment '款号' ")
	private String code;
	
	@NotNull(message = "名称")
	@Column(name = "Name",  columnDefinition = " varchar(50) default '' not null comment '名称' ")
	private String name;
	
	@NotNull(message = "店铺ID")
	@Column(name = "Shopid", columnDefinition = " varchar(50) default '' not null comment '店铺ID' ")
	private String shopid;
	
	@NotNull(message = "销售价")
	@Column(name = "Price", columnDefinition = "DECIMAL(18,2) default 0 null comment '销售价' ")
	private BigDecimal price=new BigDecimal(0);
	
	@NotNull(message = "零售价")
	@Column(name = "sale",  columnDefinition = "DECIMAL(18,2) default 0 null comment '零售价' ")
	private BigDecimal sale=new BigDecimal(0);
	
	@NotNull(message = "成本价")
	@Column(name = "cost",  columnDefinition = "DECIMAL(18,2) default 0 null comment '成本价' ")
	private BigDecimal cost=new BigDecimal(0);

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSale() {
		return sale;
	}

	public void setSale(BigDecimal sale) {
		this.sale = sale;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

		
}
