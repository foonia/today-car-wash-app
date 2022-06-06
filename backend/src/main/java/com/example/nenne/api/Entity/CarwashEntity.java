package com.example.nenne.api.Entity;

public class CarwashEntity {

    private Integer idx;
    private String name;
    private String address;
    private String latitude;
    private String longtitude;
    private Integer num;
    private Double distance;

    public CarwashEntity(Integer idx, String name, String address, String latitude,
                         String longtitude, Integer num, Double distance) {
        super();
        this.idx = idx;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.num = num;
        this.distance = distance;
    }

    public Integer getIdx() {
        return idx;
    }
    public void setIdx(Integer idx) {
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
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }

}