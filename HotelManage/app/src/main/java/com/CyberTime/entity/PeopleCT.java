package com.CyberTime.entity;

/**
 * Created by DroodSunny on 2017/7/16.
 */

public abstract class PeopleCT {

    private String name;
    private Integer age;
    private String tel;
    private String sex;

    public PeopleCT(){}

    public PeopleCT(String name, int age, String tel, String sex) {
        this.name=name;
        this.age=age;
        this.tel=tel;
        this.sex=sex;
    }

    public PeopleCT(String name) {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void printinf(){

    }
}
