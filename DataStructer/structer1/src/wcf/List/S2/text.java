package wcf.List.S2;

public class text {
    public static void main(String[] args) throws Exception {
//        System.out.println("学号\t 姓名\t 性别\t 大学英语\t 高等数学");
//        System.out.println("2008001\t Alan\t F\t 93\t 88\t");
        studentManageSystem sm=new studentManageSystem(100);
        sm.addStudent(new studentNode(10010,"温超凡","男",90,88));
        sm.addStudent(new studentNode(10011,"温超凡","男",92,98));
        System.out.println(sm.get(10010));
        sm.display();
        //sm.remove(10010);
        //sm.display();
        //sm.change(10010);
        sm.display();
        System.out.println(sm.getAverage(2));
    }
}
