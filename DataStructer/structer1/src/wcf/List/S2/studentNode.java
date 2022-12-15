package wcf.List.S2;

public class studentNode {
    public int number;
    public String name;
    public String gender;
    public int English;
    public int Math;

    public studentNode(int number,
                       String name,
                       String gender,
                       int English,
                       int Math) {
//        System.out.println("请输入学生的学号:");
//        System.out.println("请输入学生的姓名:");
//        System.out.println("请输入学生的性别:");
//        System.out.println("请输入学生的英语成绩:");
//        System.out.println("请输入学生的数学成绩:");
        this.number=number;
        this.name=name;
        this.gender=gender;
        this.English=English;
        this.Math=Math;
    }

    @Override
    public String toString() {
        return "studentNode{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", English='" + English + '\'' +
                ", Math='" + Math + '\'' +
                '}';
    }
}
