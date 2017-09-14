package com.CyberTime.entity;

/**
 * Created by DroodSunny on 2017/7/11.
 */

public class TablesCT {

    private Integer seats;
    private String isUsed;
    private Integer location;
    private String type;
    private String date;

    public float getBill() {
        return bill;
    }
    public void setBill(float bill) {
        this.bill = bill;
    }

    private float bill;
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getSeats() {
        return seats;
    }
    public void setSeats(Integer seats) {
        this.seats = seats;
    }
    public String getIsUsed() {
        return isUsed;
    }
    public void setUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    public Integer getLocation() {
        return location;
    }
    public void setLocation(Integer location) {
        this.location = location;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
