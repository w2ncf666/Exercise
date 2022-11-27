package com.wcf20221125;

public class bosicat extends cat{
    public bosicat() {
    }

    @Override
    public void eat() {
        System.out.println("我是波斯猫");
    }
    public bosicat(String name,int age){
        super(name,age);
    }
}
