package com.nextsgo.papy.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Index;
import javax.persistence.JoinTable;
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
import javax.persistence.JoinColumn;
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
@Table(name = "user", indexes = { @Index(name = "uk_full_name", columnList = "full_name", unique = true),
		@Index(name = "uk_name", columnList = "name", unique = true), })
// @SqlResultSetMapping(name = "userMapping", entities =
// @EntityResult(entityClass = User.class, fields = {
// @FieldResult(name = "id", column = "id"),
// @FieldResult(name = "name", column = "name"),
// @FieldResult(name = "fullName", column = "full_name"),
// @FieldResult(name = "password", column = "pass_word"),
// @FieldResult(name = "createDate", column = "create_date"),
// @FieldResult(name = "createorID", column = "createor_id"),
// @FieldResult(name = "modifier", column = "modifier"),
// @FieldResult(name = "verifier", column = "verifier"),
// @FieldResult(name = "disabled", column = "disabled")}))
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User extends BaseEntity {

	@NotNull(message = "用户名必传")
	@Column(name = "name", nullable = false, columnDefinition = " varchar(50) default ''   comment '用户名' ")
	private String name;

	@NotNull(message = "密码必传")
	@Column(name = "pass_word", nullable = false, columnDefinition = " char(32) default ''  comment '登陆密码' ")
	private String password;

	@NotNull(message = "中文名必传")
	@Column(name = "full_name", nullable = false, columnDefinition = " varchar(500) default ''  comment '中文名' ")
	private String fullName;

	@Column(name = "remark", nullable = false, columnDefinition = " varchar(500) default ''  comment '备注'")
	private String remark;

	@ManyToMany		
	@JoinTable(name = "user_account", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "account_id") },
			indexes = { @Index(name = "uk_user_id", columnList = "user_id"),
					@Index(name = "uk_account_id", columnList = "account_id"), }
			)
	// 1、关系维护端，负责多对多关系的绑定和解除
	// 2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(User)
	// 3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(account)
	// 4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
	// 即表名为user_account
	// 关联到主表的外键名：主表名+下划线+主表中的主键列名,即user_id
	// 关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即account_id
	// 主表就是关系维护端对应的表，从表就是关系被维护端对应的表
	private List<Account> accountList;
	
	
	@ManyToMany		
	@JoinTable(name = "user_menu", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "menu_id") },
			indexes = { @Index(name = "uk_user_id", columnList = "user_id"),
					@Index(name = "uk_menu_id", columnList = "menu_id"), }
			)
	private List<Menu> menuList;
}
