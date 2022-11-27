package com.wcf20221125;

public class lihua extends cat{
    @Override
    public void eat() {
        System.out.println("狸花猫是我");
    }

    public lihua() {
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public lihua(String name, int age) {
       super(name, age);
       System.out.println(555);
   }
}
