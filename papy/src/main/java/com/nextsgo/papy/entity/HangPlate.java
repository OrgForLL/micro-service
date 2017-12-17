package com.nextsgo.papy.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hang_plate")
public class HangPlate {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "customer_id",columnDefinition="客户id")
	private Integer customerId;
	
	@Column(name = "product",columnDefinition="品名")
	private String product;
	@Column(name = "colour",columnDefinition="颜色")
	private String colour;
	
	@Column(name = "weight",columnDefinition="重量")
	private BigDecimal weight;
	
	@Column(name = "count_pre_jin",columnDefinition="每斤个数")
	private BigDecimal countPreJin;
	
	@Column(name = "create_date",columnDefinition="创建日期")
	private  java.util.Date createDate;

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP) 
	public  java.util.Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate( java.util.Date createDate) {
		this.createDate = createDate;
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
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
	
}
