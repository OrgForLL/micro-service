package com.nextsgo.msg.entity;

public class Result<T> {
    /**错误码.*/
    private Integer errcode;

    /**提示信息.*/
    private String errmsg;

    /**具体内容.*/
    private T data;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer code) {
        this.errcode = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String msg) {
        this.errmsg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}