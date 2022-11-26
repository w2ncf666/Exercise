package com.wcf20221125;

import java.util.Scanner;

public class text3 {
    public static void main(String[] args) {
       /* Scanner sc = new Scanner(System.in);
        System.out.println("请输入");
        String s = sc.nextLine();
        int a = Integer.parseInt(s);//但是遇到空格会报错
        System.out.println(a+1);*/
        String str="12345688";
        tonumber(str);
        //System.out.println(str+1);
    }

    private static void tonumber(String str) {
        if(!str.matches("[1-9]\\d{0,9}"))
            System.out.println("输入的数据不合法");
        else {int sum=0;
            for (int i = 0; i < str.length(); i++) {
                int num= str.charAt(i)-'0';
                sum=sum*10+num;
            }
            System.out.println(sum);
            System.out.println(sum+1);
        }
    }
}
