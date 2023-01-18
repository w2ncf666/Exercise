package com.wcf.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class text {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*windows windows1=new windows();
        windows windows2=new windows();
        windows1.start();
        windows2.start();*/


       /* SendGifts gifts=new SendGifts();
        Thread t1=new Thread(gifts);
        t1.setName("小明");
        Thread t2=new Thread(gifts);
        t2.setName("小花");
        t1.start();
        t2.start();*/

        /*SendGIfts2 gIfts2=new SendGIfts2();
        //SendGIfts2 gIfts3=new SendGIfts2();
        FutureTask<Integer> futureTask=new FutureTask<>(gIfts2);
        //FutureTask<Integer> futureTask2=new FutureTask<>(gIfts3);
        Thread t1=new Thread(futureTask);
        t1.setName("wo");
        Thread t2=new Thread(futureTask);
        t2.setName("ni");
        t1.start();
        t2.start();
        Integer result1 = futureTask.get();
        System.out.println(result1);*/

        SendGIfts2 gIfts2=new SendGIfts2();
        FutureTask<Integer> futureTask=new FutureTask<>(gIfts2);
        FutureTask<Integer> futureTask2=new FutureTask<>(gIfts2);
        Thread t1=new Thread(futureTask);
        Thread t2=new Thread(futureTask2);
        t1.start();
        t2.start();


       /* sentNumber s1=new sentNumber();
        sentNumber s2=new sentNumber();
        FutureTask<Integer> futureTask=new FutureTask<>(s1);
        FutureTask<Integer> futureTask2=new FutureTask<>(s2);
        Thread t1=new Thread(futureTask);
        t1.setName("wo");
        Thread t2=new Thread(futureTask2);
        t2.setName("ni");
        t1.start();
        t2.start();
        Integer result1 = futureTask.get();
        Integer result2 = futureTask2.get();
        System.out.println(result1);
        System.out.println(result2);*/

        /*sentNumber2 st1=new sentNumber2();
        sentNumber2 st2=new sentNumber2();
        st1.start();
        st2.start();*/
    }
}
