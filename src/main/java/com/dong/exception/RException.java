package com.dong.exception;

import com.dong.enums.REnum;

public class RException extends RuntimeException{

    private static final long serialVersionUID = 4458218257274534680L;

    private Integer code;

    public RException(REnum rEnum) {
        super(rEnum.getDesc());
        this.code = rEnum.getCode();
    }

    public RException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}

