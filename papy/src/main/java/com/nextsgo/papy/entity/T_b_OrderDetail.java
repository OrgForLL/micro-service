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
@Table(name = "t_b_OrderDetail")
public class T_b_OrderDetail {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@NotNull(message = "订单ID")
	@Column(name = "Orderid",  columnDefinition = " varchar(50) default '' not null comment '订单ID' ")
	private String orderid;
	
	@NotNull(message = "产品明细ID")
	@Column(name = "GoodsDetailid",  columnDefinition = " varchar(50) default '' not null comment '产品明细ID' ")
	private String goodsDetailid;
	@NotNull(message = "零售价")
	@Column(name = "sale",  columnDefinition = "DECIMAL(18,2) default 0 null comment '零售价' ")
	private BigDecimal sale=new BigDecimal(0);
	
	@NotNull(message = "销售价")
	@Column(name = "Price", columnDefinition = "DECIMAL(18,2) default 0 null comment '销售价' ")
	private BigDecimal price=new BigDecimal(0);
	
	@NotNull(message = "数量")
	@Column(name = "Qty",  columnDefinition = " tinyint default 0 not null comment '数量' ")
	private int qty;
	
	@NotNull(message = "金额")
	@Column(name = "Amount",  columnDefinition = " DECIMAL(18,2) default 0 null comment '金额' ")
	private BigDecimal amount=new BigDecimal(0);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		orderid = orderid;
	}

	public String getGoodsDetailid() {
		return goodsDetailid;
	}

	public void setGoodsDetailid(String goodsDetailid) {
		this.goodsDetailid = goodsDetailid;
	}

	public BigDecimal getSale() {
		return sale;
	}

	public void setSale(BigDecimal sale) {
		this.sale = sale;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	
		
}
