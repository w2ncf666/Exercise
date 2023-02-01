package com.wcf.text;

import org.springframework.stereotype.Component;

@Component
public class people {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println("people的吃"+name);
    }
}
