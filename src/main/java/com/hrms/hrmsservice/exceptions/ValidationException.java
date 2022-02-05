package com.hrms.hrmsservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends Exception {

    private static final long serialVersionUID = 5041281841079302526L;

    private long errorCode;

    public ValidationException(String mesage) {
        super(mesage);
        this.errorCode = Long.parseLong("0001");
    }

    public ValidationException(Error error){
        super(error.getMessage());
        this.errorCode = error.getCode();
    }

    public ValidationException(String mesage, int errorCode) {
        super(mesage);
        if (errorCode < 0)
            errorCode *= -1;
        this.errorCode = Long.parseLong("" + errorCode);
    }
}