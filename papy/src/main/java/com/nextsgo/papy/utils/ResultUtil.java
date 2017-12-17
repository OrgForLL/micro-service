package com.nextsgo.papy.utils;

import com.nextsgo.papy.entity.*;

public class ResultUtil {
    public static Result success(Object object){
        Result result= new Result();
        result.setErrcode(0);
        result.setData(object);
        result.setErrmsg("成功");
        return result;
    }

    public static Result success( ){
      return success(null);
    }

    public static Result error(Integer intCode,String strMsg){
        Result result= new Result();
        result.setErrcode(intCode);
        result.setErrmsg(strMsg);
        return result;
    }
}