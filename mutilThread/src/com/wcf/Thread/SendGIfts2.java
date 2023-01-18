package com.wcf.Thread;

import java.util.concurrent.Callable;

public class SendGIfts2 implements Callable<Integer> {
    static int count = 10000;

    @Override
    public Integer call() throws Exception {
        while (count-->0) {
            synchronized (SendGifts.class){
                System.out.println(Thread.currentThread().getName());
            }
            Thread.sleep(10);
        }
        return null;
    }
}
