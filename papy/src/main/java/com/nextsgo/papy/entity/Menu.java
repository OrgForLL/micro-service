package com.nextsgo.papy.entity;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Index;
import javax.persistence.Table;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.nextsgo.papy.entity.base.BaseEntity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 用户
 * 
 * @author min
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
/*
 * Spring JPA 使用@CreatedDate、@CreatedBy、@LastModifiedDate、@LastModifiedBy
 * 自动生成时间和修改者
 */
@EntityListeners(AuditingEntityListener.class)
/*
 * @DynamicInsert属性:设置为true,设置为true,表示insert对象的时候,生成动态的insert语句,
 * 如果这个字段的值是null就不会加入到insert语句当中.默认false。
 * 
 * @DynamicUpdate属性:设置为true,设置为true,表示update对象的时候,生成动态的update语句,
 * 如果这个字段的值是null就不会被加入到update语句中,默认false。
 */
@DynamicInsert
@DynamicUpdate
@Table(name = "menu",
indexes = {
		@Index(name="uk_name",columnList="name",unique=true),})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Menu extends BaseEntity {

	@NotNull(message = "菜单名称必传")
	@Column(name = "name", nullable = false, columnDefinition = " varchar(50) default ''   comment '菜单名称' ")
	private String name;

	@NotNull(message = "路由")
	@Column(name = "path", nullable = false, columnDefinition = " varchar(50) default ''  comment '路由' ")
	private String path;	

	@Column(name = "sort", nullable = false, columnDefinition = " varchar(50) default ''  comment '排序' ")
	private String sort;
	
	@Column(name = "remark", nullable = false, columnDefinition = " varchar(500) default ''  comment '备注'")
	private String remark;

	@Column(name = "help", nullable = false, columnDefinition = " varchar(500) default ''  comment '帮助说明'")
	private String help;
	
	@Column(name = "parent_id", nullable=false, columnDefinition = " bigint default 0     comment '父级'")
	private Long parentId;
	
	@ManyToMany(mappedBy = "menuList")
    private List<User> userList;
}
