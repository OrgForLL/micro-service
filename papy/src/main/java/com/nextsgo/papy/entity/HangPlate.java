package com.nextsgo.papy.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
/***
 * 挂镀
 * @author min
 *
 */
@Entity
@Table(name="hang_plate")
public class HangPlate {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@Column(name = "customer_id",columnDefinition=" varchar(36) default '' not null  comment'客户id'")
	private String customerId="";
	
	@Column(name = "product",columnDefinition=" varchar(500) default ''  not null comment '品名'")
	private String product="";
	
	@Column(name = "colour",columnDefinition="varchar(50) default ''  not null comment'颜色'")
	private String colour="";
	
	@Column(name = "weight",columnDefinition="decimal(12,2) default 0  not null comment'重量'")
	private BigDecimal weight=new BigDecimal(0);
	
	@Column(name = "count_pre_jin",columnDefinition=" decimal(12,2) default 0  not null comment '每斤个数' ")
	private BigDecimal countPreJin=new BigDecimal(0);
	
	@Column(name = "number",columnDefinition="varchar(50) default ''  not null comment'单据号'")
	private String number="";
	
	@Column(name = "price",columnDefinition=" decimal(12,2) default 0  not null comment '单价' ")
	private BigDecimal price=new BigDecimal(0);	
	
	@Column(name = "after_finish",columnDefinition="varchar(50) default ''  not null comment'后道'")
	private String afterfinish="";
	
	@Column(name = "after_quantity",columnDefinition=" decimal(12,2) default 0  not null comment '后道个数' ")
	private BigDecimal afterQuantity=new BigDecimal(0);	
	
	@Column(name = "after_price",columnDefinition=" decimal(12,2) default 0  not null comment '后道单价' ")
	private BigDecimal afterPrice=new BigDecimal(0);	
	
	
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getCountPreJin() {
		return countPreJin;
	}

	public void setCountPreJin(BigDecimal countPreJin) {
		this.countPreJin = countPreJin;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getAfterfinish() {
		return afterfinish;
	}

	public void setAfterfinish(String afterfinish) {
		this.afterfinish = afterfinish;
	}

	public BigDecimal getAfterQuantity() {
		return afterQuantity;
	}

	public void setAfterQuantity(BigDecimal afterQuantity) {
		this.afterQuantity = afterQuantity;
	}

	public BigDecimal getAfterPrice() {
		return afterPrice;
	}

	public void setAfterPrice(BigDecimal afterPrice) {
		this.afterPrice = afterPrice;
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
