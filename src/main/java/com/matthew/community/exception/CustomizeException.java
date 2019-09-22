package com.matthew.community.exception;

/**
 * @Description TODO
 * @Author Matthew
 * @Date 2019/9/22 12:31
 * @Version 1.0
 */

public class CustomizeException extends RuntimeException{
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
