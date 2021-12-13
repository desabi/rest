package com.abi.exceptionhandling.exception.global;

import java.util.Date;

public enum GlobalError {

    ERROR_DATOS_ENTRADA(400, 101, "Error en datos de entrada", new Date());

    private Integer status;
    private Integer code;
    private String message;
    private Date timeStamp;

    GlobalError(Integer status, Integer code, String message, Date timeStamp){
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
