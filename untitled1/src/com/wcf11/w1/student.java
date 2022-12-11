package com.wcf11.w1;

import com.wcf11.w1.person;

public class student extends person {
    @Override
    public void work(){
        System.out.println("学生需要学习!");
    }
    public student(){
    }

    public student(String name, String gender, int age, String nationality) {
        super(name, gender, age, nationality);
    }

}
