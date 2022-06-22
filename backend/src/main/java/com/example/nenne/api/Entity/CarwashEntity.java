package com.example.nenne.api.Entity;

import lombok.Data;
import org.springframework.http.HttpStatus;


public class CarwashEntity {


    private String idx;
    private String name;
    private String address;
    private String latitude;
    private String longtitude;
    private String type;
    private String distance;

    public CarwashEntity(String idx, String name, String address, String latitude,
                         String longtitude, String type, String distance) {
        super();
        this.idx = idx;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.type = type;
        this.distance = distance;
    }

    public String getIdx() {
        return idx;
    }
    public void setIdx(String idx) {
        this.idx = idx;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongtitude() {
        return longtitude;
    }
    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }
    public String gettype() { return type; }
    public void settype(String type) {
        this.type = type;
    }
    public String getDistance() {
        return distance;
    }
    public void setDistance(String distance) {
        this.distance = distance;
    }
}