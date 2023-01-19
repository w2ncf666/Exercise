package com.wcf.Thread;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class text2 {
    public static void main(String[] args) throws UnknownHostException, UnsupportedEncodingException {

        InetAddress ad1 = InetAddress.getByName("DESKTOP-4NHPT5U");
        System.out.println(ad1);
        //System.out.println(ad1.getAddress()[1]);//getAdress返回byte数组,且是二进制
        byte[] address = ad1.getAddress();
        byte[] bytes={1,2,3};
        System.out.println(bytes);
        double d=10086.44631;
        System.out.println(String.valueOf(d)+6+"kkk");
        System.out.println(new String(bytes));
        //Byte[] bytes="{1,2,3};".getBytes();
        //        System.out.println(new String(bytes));
        System.out.println(ad1.getHostAddress());
        System.out.println(ad1.getHostName());
    }
}
