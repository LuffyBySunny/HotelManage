package com.CyberTime.entity;

/**
 * Created by DroodSunny on 2017/7/16.
 */

public class ReserveCT extends PeopleCT{
    private Integer tableID;
    private Integer userID;
    private String date;
    public Integer getTableID() {
        return tableID;
    }
    public void setTableID(Integer tableID) {
        this.tableID = tableID;
    }
    public Integer getUserID() {
        return userID;
    }
    public void setUserID(Integer userID) {
        this.userID = userID;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
