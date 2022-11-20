package text1;

public class GirlFriend {
   /* int age;
    String gender;
    String name;
    以上是公开的写法，不安全（public）

    */
    private int age;//age。gender。name都是成员变量，而public方法里面的是
              //局部变量，用this.表示成员变量，而方法里面同名的是就近原则。
    public void setAge(int a){
        if(a>=18&&a<=30)
            age=a;
        else System.out.println("女朋友年龄不合适");
    }
    public int getAge(){
        return age;
    }
    private String gender;
    public void setGender(String G){
        //可判断字符串是否合法，同上age
        gender=G;
    }
    public String getGender(){
        return gender;
    }
    private String name;

    public void setName(String n){
        //同样判断名字是否合法
        name=n;
    }
    public String getName(){
        return name;
    }

    public void sleep(){
        System.out.println("女朋友在睡觉");
    }
    public  void  eat(){
        System.out.println("女朋友在吃饭");
    }
    public GirlFriend(){          //空参构造测试，也有存在必要。可以先创建对象然后再键盘录入
        System.out.println("测试");//在自己写了有参构造之后，系统就不会帮写无参构造了。。也是构造方法的重载
    }
  public GirlFriend(String name,String gender,int age){//有参构造方法，同时初始化多个成员变量
      if(age>=18&&age<=30)
          this.age=age;
      else System.out.println("女朋友年龄不合适");
      //可判断字符串是否合法，同上age
      this.gender=gender;
      //同样判断名字是否合法
      this.name=name;
  }


}
