package com.wcf.dto;

import lombok.Data;

@Data
public class ODS {

    private String name;

    private int number;

    public ODS() {
    }

    public ODS(String name, int number) {
        this.name = name;
        this.number = number;
    }
}
