package com.wcf20221125;

public class digui {
    public static void main(String[] args) {
        int num=sum(6);
        System.out.println(num);
    }
    public static int sum(int i){
        if(i==1)
            return 1;
        else return i+sum(i-1);
    }
}
