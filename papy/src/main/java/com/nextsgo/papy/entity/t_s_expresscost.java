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
@Table(name = "t_s_expresscost")
public class t_s_expresscost {
	@Id	
	@GenericGenerator(name = "PKUUID", strategy = "uuid2")  
    @GeneratedValue(generator = "PKUUID")  
    @Column(length = 36) 
	private String id;
	
	@NotNull(message = "快递公司ID")
	@Column(name = "expressID",  columnDefinition = " varchar(50) default '' not null comment '快递公司ID' ")
	private String expressID;
	
	@NotNull(message = "城市ID")
	@Column(name = "City",  columnDefinition = " varchar(50) default '' null comment '城市ID' ")
	private String city;
	
	@NotNull(message = "运费")
	@Column(name = "fare",  columnDefinition = "DECIMAL(18,2) default 0 null comment '运费' ")
	private BigDecimal fare=new BigDecimal(0);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExpressID() {
		return expressID;
	}

	public void setExpressID(String expressID) {
		this.expressID = expressID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		city = city;
	}

	public BigDecimal getFare() {
		return fare;
	}

	public void setFare(BigDecimal fare) {
		this.fare = fare;
	}

	

}
