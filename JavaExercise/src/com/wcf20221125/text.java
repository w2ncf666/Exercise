package com.wcf20221125;

public class text {
    public static void main(String[] args) {
        int count=0;
        for (int i = 1000; i < 10000; i++) {
            int ge=i%10;
            int shi=i/10%10;
            int bai=i/100%10;
            int qian=i/1000%10;
            if(Math.pow(ge,4)+Math.pow(shi,4)+Math.pow(bai,4)+Math.pow(qian,4)==i){
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }
}
