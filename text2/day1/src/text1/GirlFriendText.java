package text1;

public class GirlFriendText {
    public static void main(String[] args) {
        GirlFriend gir1=new GirlFriend();//空参构造方法，如果自己没写任何构造方法，那么虚拟机会帮助写一个空参构造方法
        gir1.setName("黄石东");
        gir1.setAge(18);
        gir1.setGender("铁血硬汉");
        gir1.eat();
        gir1.sleep();
        System.out.println(gir1.getName());
        System.out.println(gir1.getAge());
        System.out.println(gir1.getGender());
    }
}
