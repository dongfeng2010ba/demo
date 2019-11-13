package com.dong.demo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SeaFileResultRV<T> implements Serializable {

    private static final long serialVersionUID = 8926617609341050354L;
    /**
     * 状态码
     */
    private Integer resultCode;
    /**
     * 返回信息
     */
    private String resultMessage;
    /**
     * 返回数据
     */
    private T resultData;

}

