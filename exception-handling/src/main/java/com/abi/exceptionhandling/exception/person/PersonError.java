package com.abi.exceptionhandling.exception.person;

import java.util.Date;

public enum PersonError {

    ERROR_NOT_FOUND(404, 102, "Person not found", new Date());

    private Integer status;
    private Integer code;
    private String message;
    private Date timeStamp;

    PersonError(Integer status, Integer code, String message, Date timeStamp) {
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

    public String getMessage() {
        return message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }
}
