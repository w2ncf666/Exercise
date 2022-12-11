package com.wcf11.w1;

import com.wcf11.w1.student;

public class studentMonitor extends student {
    public studentMonitor() {
    }

    public studentMonitor(String name, String gender, int age, String nationality) {
        super(name, gender, age, nationality);
    }
    public void job(){
        System.out.println("学生干部喜欢开会!");
    }
}
