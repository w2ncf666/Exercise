package com.wcf11_29;

import java.util.*;

public class pickUpName {
    public static void main(String[] args) {
        ArrayList<String> student = new ArrayList<>();
        Collections.addAll(student, "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", "拾");
        ArrayList<String>student2=new ArrayList<>();
        student2.addAll(student);
        Random r = new Random();
        int a = r.nextInt(10);
        System.out.println(student.get(a));
        int b = student.size();
        String []s={"sdasd","sadasdasd"};
        Integer s2[]={1,2,3,4,5};
        System.out.println(s[0].startsWith("s"));
        System.out.println("----------------------------");
        for (int i = 0; i < b; i++) {
            //System.out.println(student.get(r.nextInt(student.size())));
            System.out.println(student.remove(r.nextInt(student.size())));//注意随机数大小应从student.size算,不然会越界
        }
        ArrayList<Integer> percent1 = new ArrayList<>();
        Collections.addAll(percent1, 1, 1, 1, 1, 1, 1, 1,0,0,0);
        for (int i = 0; i < 5; i++) {
            if(percent1.get(r.nextInt(percent1.size()))==1)
                System.out.println( "男");
            else System.out.println("女");//概率抽取
        }
        int time=10;
        ArrayList<String> temp=new ArrayList<>();

        for (int i = 0; i < time; i++) {
            System.out.println("第"+(i+1)+"次-----------------------------");
            for (int j = 0; j < b; j++) {
                String name=student2.get(r.nextInt(student2.size()));
                student2.remove(name);
                System.out.print(name+" ");
                temp.add(name);
            }
            System.out.println();
            student2.addAll(temp);
            temp.clear();
        }
    }
}
