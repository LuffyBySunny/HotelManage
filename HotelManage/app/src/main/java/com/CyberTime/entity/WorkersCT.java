package com.CyberTime.entity;

/**
 * Created by DroodSunny on 2017/7/11.
 */

public class WorkersCT extends PeopleCT{
    private String power;
    private String pwd;

    public WorkersCT(){}
    public WorkersCT(String name,int age,String tel,String power,String sex,String pwd){
        super(name,age,tel,sex);
        this.power=power;
        this.pwd=pwd;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
