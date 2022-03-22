package com.nextsgo.papy.entity.base;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.nextsgo.papy.entity.converter.AuditStatusConverter;
import com.nextsgo.papy.entity.converter.VerifyStatusConverter;
import com.nextsgo.papy.enums.AuditStatusEnum;
import com.nextsgo.papy.enums.VerifyStatusEnum;

import lombok.Data;

/**
 * 通用字段
 * @author min
 *
 */
@MappedSuperclass
@Data
public class BaseEntity {

	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "identity")
	protected Long id;
	
	@Column(name = "is_invalid", nullable=false, columnDefinition = " tinyint unsigned default 0    comment '无效'")
	private Boolean invalid=false;	
	
	@CreatedDate
	@Column(name = "gmt_create", nullable=false,columnDefinition = " datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间【系统级别】'")
	private java.util.Date gmtCreate;
	
	@LastModifiedDate
	@Column(name = "gmt_modified", nullable=false,columnDefinition = " datetime DEFAULT CURRENT_TIMESTAMP comment '最后一次修改时间【系统级别】'")
	private java.util.Date gmtModified;
	
	
	@Column(name = "create_date", columnDefinition = " datetime comment '创建日期'")
	private java.util.Date createDate;
	
	@Column(name = "creator", nullable=false, columnDefinition = " bigint default 0   comment '创建人'")
	private Long creator ;
	
	@Column(name = "modify_date", columnDefinition = " datetime comment '修改日期'")
	private java.util.Date modifyDate;
	
	@Column(name = "modifier", nullable=false, columnDefinition = " bigint default 0     comment '修改人'")
	private Long modifier;
	
	/**
    * 利用 @Convert 指向自定义转换类VerifyStatusConverter
    * 此时JPA会根据自定义转换规则对VerifyStatus枚举类进行存取
    */
    @Convert(converter = VerifyStatusConverter.class)
	@Column(name = "verify_status", nullable=false, columnDefinition = " int default 0   comment '确认状态'")
	private VerifyStatusEnum verifyStatus;
	
	@Column(name = "verifier", nullable=false, columnDefinition = " bigint default 0   comment '确认人'")
	private Long verifier;	
	
	@Convert(converter = AuditStatusConverter.class)
	@Column(name = "audit_status", nullable=false, columnDefinition = " int default 0   comment '审核状态'")
	private AuditStatusEnum auditStatus;	
	
	@Column(name = "auditor", nullable=false, columnDefinition = " bigint default 0   comment '审核人'")
	private Long auditor;
	
}
