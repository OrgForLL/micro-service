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
@Table(name = "t_s_GoodsDetail")
public class T_s_GoodsDetail {
	
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@NotNull(message = "款号ID")
	@Column(name = "GoodsID", columnDefinition = " varchar(50) default '' not null comment '款号ID' ")
	private String goodsID;
	
	@NotNull(message = "颜色ID")
	@Column(name = "colorID",  columnDefinition = " varchar(50) default '' not null comment '颜色ID' ")
	private String colorID;
	
	@NotNull(message = "尺码ID")
	@Column(name = "SizeID", columnDefinition = "varchar(50) default '' not null comment '尺码ID' ")
	private String sizeID;
	
	@NotNull(message = "条码")
	@Column(name = "BarCode", columnDefinition = " varchar(50) default '' null comment '条码' ")
	private String barCode;
	
	@NotNull(message = "销售价")
	@Column(name = "Price", columnDefinition = "DECIMAL(18,2) default 0 null comment '销售价' ")
	private BigDecimal price=new BigDecimal(0);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public String getColorID() {
		return colorID;
	}

	public void setColorID(String colorID) {
		this.colorID = colorID;
	}

	public String getSizeID() {
		return sizeID;
	}

	public void setSizeID(String sizeID) {
		this.sizeID = sizeID;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
}
