package com.matthew.community.exception;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/22 12:31
 * @Version 1.0
 */

public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
