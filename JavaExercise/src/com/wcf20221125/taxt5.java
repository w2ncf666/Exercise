package com.wcf20221125;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class taxt5 {
    public static void main(String[] args) {
       lihua n=new lihua("sad",2);
       bosicat b=new bosicat("波斯",3);
//
//        System.out.println(n.getName());
//        n.eat();
//
//        System.out.println(n.getAge());
        ArrayList<cat> list1=new ArrayList<>();
        list1.add(n);
        list1.add(b);
        keeppet(list1);
        System.out.println(n);
        System.out.println(n.toString());//不必要,
        System.out.println(n.getName());
        System.out.println("----------------------------------------");
    }//泛型不具备继承性,但数据具备继承性 比如可以在ArrayList<cat> 的list1 中添加具体的lihua(狸花猫),但是不可以在keeppet方法中
    //                                                                   传递ArrayList<lihua> 的list1
    public static void keeppet(ArrayList<?extends cat > list){//?extend可继承写法  同时是泛型
    /*  Iterator<?extends cat> it=list.iterator();
      while(it.hasNext()){
          it.next().eat();//迭代器写法
      }
      */
        list.forEach(cat ->cat.eat());//敛步达表达式  也是foreach方法   IDEA提示方法引用?
     /*   list.forEach(new Consumer<cat>() {
            @Override
            public void accept(cat cat) {
                cat.eat();
            }
        });*///匿名内部类写法
      /*  for (cat cat : list) {//增强for写法
            cat.eat();
        }*/
    }
}
