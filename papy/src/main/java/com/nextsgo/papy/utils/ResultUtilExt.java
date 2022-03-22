package com.nextsgo.papy.utils;

import com.nextsgo.common.entity.Result;
import com.nextsgo.common.tools.ResultUtil;
import com.nextsgo.papy.enums.ErrorStatusEnum;
public class ResultUtilExt extends ResultUtil {
	
    public static Result<?> error(ErrorStatusEnum error,String strMsg){      
        return ResultUtil.error(error.getCode(), strMsg);
    }
    
    public static Result<?> error(ErrorStatusEnum error){
        return ResultUtil.error(error.getCode(), error.getMsg());
    }
}
