package com.wcf11.w1;

import com.wcf11.w1.person;

public class worker extends person {
    public worker() {
    }

    public worker(String name, String gender, int age, String nationality) {
        super(name, gender, age, nationality);
    }

    @Override
    public void work() {
        System.out.println("工人的工作是搬砖!");
    }
}
