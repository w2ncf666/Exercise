package com.wcf11.w2;

public class text {
    public static void main(String[] args) {
        //分析以下需求用代码实现:
        //
        //1. 定义形状类:
        //
        //   功能：求面积，求周长
        //
        //2. 定义圆形类Round:
        //
        //   属性：半径，圆周率
        //
        //   功能：求面积，求周长
        //
        //3. 定义长方形类Rectangle:
        //
        //   	属性：长和宽
        //
        //   功能：求面积，求周长
        //
        //4. 定义测试类:
        //
        //   	分别创建圆形和长方形对象，为相应的属性赋值
        //
        //   分别调用求面积和求周长的方法
map m1=new rectangle(3,4);
m1.getarea();
        System.out.println("------------------------------------------");
        getarea2(m1);
        System.out.println("------------------------------------------");
        map m2=new round(2);
        m2.getarea();
        System.out.println("------------------------------------------");
        getarea2(m2);
    }
    public static void getarea2(map m){
        if(m instanceof rectangle){
            System.out.println("面积是"+(((rectangle) m).getLength()*((rectangle) m).getLong()));
            System.out.println("周长是"+((((rectangle) m).getLength()+((rectangle) m).getLong())*2));
        } else if (m instanceof round) {
            System.out.println("面积是"+(Math.PI*((round) m).getR()*((round) m).getR()));
            System.out.println("周长是"+(Math.PI*2*((round) m).getR()));
        }

    }
}
