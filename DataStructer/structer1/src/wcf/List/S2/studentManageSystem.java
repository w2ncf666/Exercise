package wcf.List.S2;

import wcf.List.S1.Sqlist;

import java.io.Serializable;
import java.util.Scanner;

public class studentManageSystem extends Sqlist implements Serializable {
    public studentManageSystem(int maxlength) {
        super(maxlength);
    }
    @Override
    public void display() throws Exception {
        System.out.println("学号\t 姓名\t 性别\t 大学英语\t 高等数学");
        for (int i = 0; i < currentLength(); i++) {
            studentNode s = (studentNode) super.get(i);
            System.out.println(s.number + "\t" + s.name + " \t" + s.gender + " \t" + s.English + "\t" + s.Math + "\t");
            System.out.println();
        }
    }

    public void addStudent(studentNode s) throws Exception {
        super.insert(currentLength(), s);
    }

    public studentNode get(int number) throws Exception {
        for (int i = 0; i < currentLength(); i++) {
            studentNode s = (studentNode) super.get(i);
            if (number == s.number)
                return s;
        }
        throw new Exception(number + "的学生不存在");

    }

    public void remove(int number) throws Exception {
        int i=indexof(number);
        if (i== -1)
            throw new Exception(number + "的学生不存在");
        super.remove(i);
    }

    public void change(int number) throws Exception {
        int i=indexof(number);
        if(i==-1)
            throw new Exception(number + "的学生不存在");
        remove(number);
        Scanner sc=new Scanner(System.in);
        System.out.println("请重新录入学生的学号,姓名,性别,英语成绩,数学成绩");
        insert(i,new studentNode(sc.nextInt(),sc.next(),sc.next(),sc.nextInt(),sc.nextInt()));
        System.out.println("修改成功!");

    }

    private int indexof(int number) throws Exception {
        for (int i = 0; i < currentLength(); i++) {
            studentNode s = (studentNode) super.get(i);
            if (number == s.number)
                return i;
        }
        return -1;
    }
    public double getAverage(int target) throws Exception {
        double sum=0.0;
        double average=0.0;
        switch (target){
            case 1:
                for (int i = 0; i < currentLength(); i++) {
                    studentNode s=(studentNode)super.get(i);
                    sum+=s.English;
                }
               break;
            case 2:
                for (int i = 0; i < currentLength(); i++) {
                    studentNode s=(studentNode)super.get(i);
                    sum+=s.Math;
                }
                break;
            default:
                System.out.println("输入错误!没有"+target+"科目");
        }
        return sum/currentLength();
    }
}
