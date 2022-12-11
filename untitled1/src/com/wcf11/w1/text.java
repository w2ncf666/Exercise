package com.wcf11.w1;

import com.wcf11.w1.student;
import com.wcf11.w1.studentMonitor;
import com.wcf11.w1.worker;

public class text {
    public static void main(String[] args) {
        enum choice{ADD,LOOK,SEARCH,CHANGE,DELETE,EXIT}
        System.out.println(choice.valueOf("ADD"));
        student stu=new student("黄石东","男",18,"啊美利坚");
        System.out.println(stu);
        stu.work();
        stu.eat();
        worker work=new worker();
        work.setAge(18);
        work.setGender("nv");
        System.out.println(work);
        work.eat();
        work.work();
        studentMonitor stM=new studentMonitor("温超凡","男",20,"天朝");
        stM.job();
        stM.work();

        System.out.println(stM);
        //System.out.println(choice);
//switch ()
        }
    }
//1.定义Person类
//
//​		属性：
//
//​			姓名name、性别gender、年龄age、国籍nationality；
//
//​		方法：
//
//​			吃饭eat、睡觉sleep，工作work。
//
//​	2.根据人类，创建一个学生类Student
//
//​		增加属性：
//
//​			学校school、学号stuNumber；
//
//​		重写工作方法（学生的工作是学习）。
//
//​	3.根据人类，创建一个工人类Worker
//
//​		增加属性：
//
//​			单位unit、工龄workAge；
//
//​		重写工作方法（工人的工作是盖房子）。
//
//​	4.根据学生类，创建一个学生干部类 StudentLeader
//
//​		增加属性：
//
//​			职务job；
//
//​		增加方法：开会meeting。
//
//​	5.编写测试类分别对上述3类具体人物进行测试。
//
//​	6.要求运行结果:学生需要学习!
//工人的工作是盖房子!
//学生干部喜欢开会!