package com.wcf.Thread;

import java.util.concurrent.Callable;

public class sentNumber2 extends Thread {
    static int number = 10000;
    static int count=0;

    @Override
    public void run() {
        while (true) {
            synchronized (SendGifts.class) {
                if (number < 1)
                    break;
                else {
                    if (number % 2 == 1){
                        System.out.println(Thread.currentThread()+""+number);
                        count++;
                    }
                    number--;
                }
            }
        }
    }
}
