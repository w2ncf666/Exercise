package com.wcf.text;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
/*@Scope("prototype")  非单例对象不能执行生命周期的销毁方法,创建的对象不归spring管理*/
public class textBean {
    @Autowired
    private people people;
    private String name;
    @Value("${name}")
private String gender;
    public int text;
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public people getPeople() {
        return people;
    }

    public void setPeople(people people) {
        this.people = people;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int eat(people people){
        System.out.println(name+"吃东西");
        people.eat();
    /*    int i=1/0;*/
        this.text=7;
        System.out.println("text "+text);
        return 666;
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁");
    }

}
