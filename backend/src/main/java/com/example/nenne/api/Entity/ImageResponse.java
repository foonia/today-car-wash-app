package com.example.nenne.api.Entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ImageResponse {

    private HttpStatus status;
    private String code;
    private Object items;

    public ImageResponse() {
        this.status = null;
        this.code = null;
        this.items = null;

    }
}
