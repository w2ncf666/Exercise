package com.wcf.Thread;

public class windows extends Thread{
    static int count=0;
    @Override
    public void run() {
        while (true){
            synchronized (windows.class){
                if(count==100000)
                    break;
                else {
                    count++;
                    System.out.println(getName()+"正在售卖第"+count+"张票!!");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
