package com.dong.exception;


import com.common.utils.R;
import com.dong.enums.REnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(RExceptionHandler.class);

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RException.class)
    public R handleRRException(RException e){
        logger.error(e.getMessage(), e);
        RException rException = (RException)e;
        return R.error(rException.getCode(), rException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        logger.info("[系统异常]{}", e);
        return R.error(REnum.UNKNOWN_ERROR);
    }


}

