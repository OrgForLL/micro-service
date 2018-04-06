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
@Table(name = "t_b_Order")
public class t_b_Order {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@NotNull(message = "用户ID")
	@Column(name = "userid",  columnDefinition = " varchar(50) default '' not null comment '用户ID' ")
	private String userid;
	
	@NotNull(message = "店铺用户ID")
	@Column(name = "ShopUserid", columnDefinition = " varchar(50) default '' not null comment '店铺用户ID' ")
	private String shopUserid;
	
	@NotNull(message = "会员收货地址ID")
	@Column(name = "addressID",columnDefinition = " varchar(50) default '' not null comment '会员收货地址ID' ")
	private String addressID;
	
	@NotNull(message = "总金额")
	@Column(name = "TotalAmount", columnDefinition = " DECIMAL(18,2) default 0 null comment '总金额' ")
	private BigDecimal totalAmount=new BigDecimal(0);
	
	@NotNull(message = "总数量")
	@Column(name = "TotalQty", columnDefinition = " tinyint default 0 null comment '总数量' ")
	private int totalQty;
	
	@NotNull(message = "订单编号")
	@Column(name = "BillCode", columnDefinition = " varchar(50) default '' null comment '订单编号' ")
	private String billCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getShopUserid() {
		return shopUserid;
	}

	public void setShopUserid(String shopUserid) {
		this.shopUserid = shopUserid;
	}

	public String getAddressID() {
		return addressID;
	}

	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalQty() {
		return totalQty;
	}

	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	
	
}
