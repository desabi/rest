package com.abi.exceptionhandling.exception.global;


import java.util.Date;

public class CustomException extends Exception {

    private Integer status;
    private Integer code;
    private String message;
    private Date timeStamp;

    public CustomException(Integer status, Integer code, String message, Date timeStamp) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
