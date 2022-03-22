package com.nextsgo.papy.entity.converter;

import javax.persistence.AttributeConverter;

import com.nextsgo.papy.enums.AuditStatusEnum;

public class AuditStatusConverter implements AttributeConverter<AuditStatusEnum, Integer>{
 
    /**
     * convertToDatabaseColumn方法是转换数据到表中
     * 这里是将AuditStatusEnum 枚举的value存入表中
     */
	@Override
	public Integer convertToDatabaseColumn(AuditStatusEnum attribute) {
		if(attribute == null){
			throw new RuntimeException("Unknown AuditStatusEnum text : " + attribute);
		}
		return attribute.getValue();
	}

    /**
     * convertToEntityAttribute方法是转换表中的值转换回数据
     * 这里是将表中的枚举的value值转换成AuditStatusEnum枚举
     */
	@Override
	public AuditStatusEnum convertToEntityAttribute(Integer dbData) {
		for(AuditStatusEnum s : AuditStatusEnum.values()){
			if(s.getValue() == (dbData)){
				return s;
			}
		}
		throw new RuntimeException("Unknown AuditStatusEnum text : " + dbData);
	}
	
}
