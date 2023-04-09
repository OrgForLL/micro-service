package com.nextsgo.papy.dto;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
 
import java.util.Date;
import lombok.Data;

@Data
public class PapyData {
    public int pageNo;
    public int pageSize;
    public String personName;
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ssZ")
    public Date  startTime;
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd'T'HH:mm:ssZ")
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date  endTime;
}
