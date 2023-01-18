package com.wcf.Thread;

public class SendGifts implements Runnable {
    static int count=10000;
    @Override
    public void run() {
        while (true){
            synchronized (SendGifts.class){
                if(count<10)
                    break;
                else{
                    count--;
                    System.out.println(Thread.currentThread()+"正在送出第"+(10000-count)+"个礼物!!");
                }
            }
        }
    }
}
