package com.abi.exceptionhandling.exception.person;

import com.abi.exceptionhandling.exception.global.CustomException;

import java.util.Date;

public class PersonException extends CustomException {
    public PersonException(PersonError personError) {
        super(personError.getStatus(), personError.getCode(), personError.getMessage(), personError.getTimeStamp());
    }
}
