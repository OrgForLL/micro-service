package com.nextsgo.papy.entity.converter;

import javax.persistence.AttributeConverter;

import com.nextsgo.papy.enums.VerifyStatusEnum;

public class VerifyStatusConverter implements AttributeConverter<VerifyStatusEnum, Integer>{
 
    /**
     * convertToDatabaseColumn方法是转换数据到表中
     * 这里是将VerifyStatusEnum 枚举的value存入表中
     */
	@Override
	public Integer convertToDatabaseColumn(VerifyStatusEnum attribute) {
		if(attribute == null){
			throw new RuntimeException("Unknown VerifyStatusEnum text : " + attribute);
		}
		return attribute.getValue();
	}
 
    /**
     * convertToEntityAttribute方法是转换表中的值转换回数据
     * 这里是将表中的枚举的value值转换成VerifyStatusEnum枚举
     */
	@Override
	public VerifyStatusEnum convertToEntityAttribute(Integer dbData) {
		for(VerifyStatusEnum s : VerifyStatusEnum.values()){
			if(s.getValue() == (dbData)){
				return s;
			}
		}
		throw new RuntimeException("Unknown VerifyStatusEnum text : " + dbData);
	}
	
}
