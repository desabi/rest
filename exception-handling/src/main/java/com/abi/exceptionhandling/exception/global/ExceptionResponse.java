package com.abi.exceptionhandling.exception.global;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ExceptionResponse {

    private Integer status;
    private Integer code;
    private String message;
    private Date timeStamp;

}
