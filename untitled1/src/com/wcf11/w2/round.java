package com.wcf11.w2;

public class round extends map{
    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public round(int r) {
        this.r = r;
    }

    public round() {
    }

    private int r;
    public void getarea(){
        System.out.println("面积是"+(Math.PI*r*r));
        System.out.println("周长是"+(2*Math.PI*r));
    }
}
