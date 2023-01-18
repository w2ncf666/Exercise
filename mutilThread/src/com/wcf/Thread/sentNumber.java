package com.wcf.Thread;

import java.util.concurrent.Callable;

public class sentNumber implements Callable<Integer> {
    static int number = 100;
    static int count=0;
    @Override
    public Integer call() throws Exception {
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
        return count;
    }
}
