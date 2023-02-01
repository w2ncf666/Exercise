package com.wcf.controller;

import com.wcf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/*@Controller//设定SpringMVC的核心控制器bean
@ResponseBody*/
@RestController//上面两个的组合
@RequestMapping("/users")
public class UserController {
    //@RequestMapping("/save")//设置当前控制器方法请求访问路径
    //@ResponseBody//设置当前控制器方法响应内容为当前返回值，无需解析(http)
    @PostMapping
    public String save(@RequestBody String name){
        System.out.println("传递的参数"+name);
        System.out.println("user save...");
        return "7777";//json数据(假的,对象才会自动转换成json)
    }


    //@RequestMapping(value = "/delete/{name}",method = RequestMethod.POST)
    //@ResponseBody
    @GetMapping("/{name}/{age}")
    public String delete(@PathVariable String name , @PathVariable int age){
        System.out.println("传递的参数"+name+age);
        System.out.println("user delete");
        return "user delete";
    }
    //@RequestMapping("/pojoParam")
    //@ResponseBody
    @DeleteMapping("/{id}")
    public String pojoParam(@PathVariable int id ){
        System.out.println("接收的参数"+id);
        return "user";
    }

    //@RequestMapping("/arrayParam")
    //@ResponseBody
    public User arrayParam(String[] likes){
        System.out.println("数组参数传递 likes ==> "+ Arrays.toString(likes));
        User user = new User();
        user.setName("itcast");
        user.setAge(15);
        return user;
    }

    //@RequestMapping("/listParam")
    //@ResponseBody
    public String listParam(@RequestParam List<String> likes){
        System.out.println("集合参数传递 likes ==> "+ likes);
        return "{'module':'list param'}";
    }
}
