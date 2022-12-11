package com.wcf11.w1;

public abstract class person {
    private String name;
    private String gender;
    private int age;
    private String nationality;

    public person() {
    }

    public person(String name, String gender, int age, String nationality) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void eat() {
        System.out.println(name + "在吃饭");
    }

    public void sleep() {
        System.out.println(name + "在睡觉");
    }
public abstract void work();

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}