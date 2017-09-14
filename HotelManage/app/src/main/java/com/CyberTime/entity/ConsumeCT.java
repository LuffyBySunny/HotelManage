package com.CyberTime.entity;

/**
 * Created by DroodSunny on 2017/7/16.
 */

public class ConsumeCT {

    public ConsumeCT(){}
    public ConsumeCT(Integer fare){
        this.fare=fare;
    }
    private Integer fare;
    public Integer getFare() {
        return fare;
    }
    public void setFare(Integer fare) {
        this.fare = fare;
    }

}
