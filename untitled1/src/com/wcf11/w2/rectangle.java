package com.wcf11.w2;

public class rectangle extends map{
   private int Long;
   private  int length;

    @Override
    public void getarea() {
        System.out.println("面积是"+(Long*length));
        System.out.println("周长是"+((Long+length)*2));
    }

    public int getLong() {
        return Long;
    }

    public void setLong(int aLong) {
        Long = aLong;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public rectangle(int aLong, int length) {
        Long = aLong;
        this.length = length;
    }

    public rectangle() {
    }
}
