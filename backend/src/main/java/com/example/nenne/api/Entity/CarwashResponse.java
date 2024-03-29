package com.example.nenne.api.Entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CarwashResponse {

    private String code;
    private HttpStatus status;
    private Object items;

    public CarwashResponse() {
        this.status = null;
        this.code = null;
        this.items = null;
    }

}
