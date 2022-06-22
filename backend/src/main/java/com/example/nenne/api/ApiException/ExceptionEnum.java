package com.example.nenne.api.ApiException;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ExceptionEnum {
    RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "400"),
    ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "401"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Key values are not equal"),
    MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION(HttpStatus.BAD_REQUEST, "400", "There is a parameter value that does not exist"),

    SECURITY_01(HttpStatus.BAD_REQUEST, "400");

    private final HttpStatus status;
    private final String code;
    private String message;

    ExceptionEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

    ExceptionEnum(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
