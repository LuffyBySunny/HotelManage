package com.CyberTime.entity;

/**
 * Created by DroodSunny on 2017/7/11.
 */

public class MembersCT extends PeopleCT{

    private String name;
    private Integer points;
    public MembersCT(){
        super();
    }
    public MembersCT(String name,Integer points){
        super(name);
        this.points=points;
    }
    public Integer getPoints() {
        return points;
    }
    public void setPoints(Integer points) {
        this.points = points;
    }
}
