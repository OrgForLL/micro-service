package com.nextsgo.papy.entity;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Index;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.nextsgo.papy.entity.base.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode; 
/**
 * 客户
 * @author min
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
/* @DynamicInsert属性:设置为true,设置为true,表示insert对象的时候,生成动态的insert语句,如果这个字段的值是null就不会加入到insert语句当中.默认false。
@DynamicUpdate属性:设置为true,设置为true,表示update对象的时候,生成动态的update语句,如果这个字段的值是null就不会被加入到update语句中,默认false。
 */
@DynamicInsert
@DynamicUpdate
@Table(name = "customer",
indexes = {@Index(name="uk_number",columnList="number",unique=true),
		@Index(name="uk_name",columnList="name",unique=true),})
public class Customer extends BaseEntity {
	
	@NotNull(message = "客户编号必传")
	@Column(name = "number",  nullable=false, columnDefinition = " varchar(50) default ''  comment '客户编号' ")
	private String number;
	
	@NotNull(message = "客户名必传")
	@Column(name = "name",  nullable=false, columnDefinition = " varchar(500) default ''  comment '客户名' ")	
	private String name;
	
	@Column(name = "tel", nullable=false, columnDefinition = " varchar(50) default ''  comment '电话号码' ")
	private String tel;
	
	@Column(name = "remark", nullable=false, columnDefinition = " varchar(500) default ''   comment '备注'")
	private String remark;
}

