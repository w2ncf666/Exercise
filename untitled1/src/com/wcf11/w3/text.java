package com.wcf11.w3;

public class text {
    public static void main(String[] args) {
        //1. 定义手机类
        //
        //​	行为：打电话,发短信
        //
        //2. 定义接口IPlay
        //
        //​	行为：玩游戏
        //
        //3. 定义旧手机类继承手机类
        //
        //​	行为：继承父类的行为
        //
        //4. 定义新手机继承手机类实现IPlay接口
        //
        //   行为：继承父类的行为,重写玩游戏方法
        //
        //5. 定义测试类
        //
        //​	在测试类中定义一个 用手机的方法,要求该方法既能接收老手机对象,也能接收新手机对象
        //
        //​	在该方法内部调用打电话,发短信以及新手机特有的玩游戏方法
        phone p1=new newPhone();
        usephone(p1);
        System.out.println("---------------------");
        phone p2=new oldPhone();
        usephone(p2);
        Iplay.method();
        System.out.println("---------------------");
        Iplay i=new Iplay() {
            @Override
            public void playgame() {
                System.out.println("我");
            }
        };
        ( (newPhone) p1).text(i);//匿名内部类
        /*    ( (newPhone) p1).text(new Iplay() {
            @Override
            public void playgame() {
                System.out.println("我");
            }
        });*/
    }
    public static void usephone(phone p){
        p.call();
        p.sendmessage();
        if(p instanceof newPhone)
            ((newPhone) p).playgame();
         else if (p instanceof oldPhone)
            ((oldPhone) p).playgame();
    }
}
