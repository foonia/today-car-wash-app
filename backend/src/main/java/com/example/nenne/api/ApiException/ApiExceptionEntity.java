package com.example.nenne.api.ApiException;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@ToString
public class ApiExceptionEntity {

    private LocalDateTime Timestamp;
    private String errorCode;
    private String errorMessage;

    @Builder
    public ApiExceptionEntity(HttpStatus status,LocalDateTime Timestamp, String errorCode, String errorMessage){
        this.Timestamp = Timestamp;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
