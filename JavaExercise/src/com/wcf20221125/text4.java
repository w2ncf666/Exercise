package com.wcf20221125;

import java.util.Arrays;

public class text4 {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        int []a={8,7,6,5,4,3,2,1};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr.toString());
        System.out.println();
        int []b=Arrays.copyOf(a,8);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println(b.toString());
        System.out.println();
        System.out.println(Arrays.toString(arr));//数组转换成字符串
        System.out.println(arr);//直接打印地址,arr.toString一样都是打印地址
    }
}
