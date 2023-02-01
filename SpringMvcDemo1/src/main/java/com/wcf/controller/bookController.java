package com.wcf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/book")
public class bookController {


    @RequestMapping("/save")
    //@ResponseBody
    public String save(){
        System.out.println("book save..");
        return "index.jsp";
    }
}
