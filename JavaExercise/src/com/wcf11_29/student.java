package com.wcf11_29;

public class student {
    private String name;
    private  int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String lengthen(){
        return name+"-"+age;
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
}
