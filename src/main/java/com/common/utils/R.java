package com.common.utils;

import com.dong.enums.REnum;
import com.google.gson.Gson;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class R<T> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("返回码(200-代表成功)")
    private Integer status = 200;

    @ApiModelProperty("提示信息")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;

    public static R ok() {
        return new R();
    }

    public static<T>  R<T> okMsg(String message) {
        R<T> r = new R<T>();
        r.setMessage(message);
        return r;
    }

    public static<T>  R<T> ok(T data) {
        R<T> r = new R<T>();
        r.setData(data);
        return r;
    }

    public static<T>  R<T> ok(T data,String message) {
        R r = new R();
        r.setData(data);
        r.setMessage(message);
        return r;
    }

    public static R error(Integer status, String message) {
        R r = new R();
        r.setStatus(status);
        r.setMessage(message);
        return r;
    }

    public static R error(REnum rEnum) {
        R r = new R();
        r.setStatus(rEnum.getCode());
        r.setMessage(rEnum.getDesc());
        return r;
    }
    @Override
    public String toString() {
        return "R [status=" + status + ", message=" + message + ", data=" + new Gson().toJson(data) + "]";
    }
}

