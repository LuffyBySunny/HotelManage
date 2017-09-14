package com.CyberTime.entity;

/**
 * Created by DroodSunny on 2017/7/17.
 */

public class TabDisCT {
    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }
    private Integer num;
    private Integer tabID;
    private Integer disID;
    public Integer getTabID() {
        return tabID;
    }
    public void setTabID(Integer tabID) {
        this.tabID = tabID;
    }
    public Integer getDisID() {
        return disID;
    }
    public void setDisID(Integer disID) {
        this.disID = disID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
