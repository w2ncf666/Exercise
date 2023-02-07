package com.wcf.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wcf.Util.ValidateCodeUtils;
import com.wcf.dao.UserMapper;
import com.wcf.pojo.R;
import com.wcf.reastic.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class userController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        String phone = user.getPhone();//根据手机号发送阿里云验证码
        log.info(phone+"看手机号");
        if(StringUtils.isNotEmpty(phone)) {
            String code = ValidateCodeUtils.generateValidateCode4String(4);
            log.info(code);
            session.setAttribute(phone, code);
            return R.success("手机验证码发送成功!");
        }
        return R.error("请输入手机号");
    }


    @PostMapping("/login")
    public R<String> login(@RequestBody Map<String, String> map, HttpSession session) {
        //查询用户在不在数据库,完成注册
        log.info(map.get("phone"));
        log.info(map.toString());
        log.info("看上面");
        String phone = map.get("phone");
        String code = map.get("code");
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(StringUtils.isNotEmpty(phone), User::getPhone, phone);
        User one = userMapper.selectOne(lqw);
        log.info(session.getAttribute(phone).toString()+"这人撒旦");
        if (session.getAttribute(phone).equals(code)) {
            if (one == null) {
                one = new User();
                one.setPhone(phone);
                userMapper.insert(one);
            }
            log.info("得到的id是"+one.getId());
            session.setAttribute("user",one.getId());
            return R.success("用户登陆成功!");
        }

        return R.error("验证码错误");

    }


    @PostMapping("/logout")
    public R<String> logout(HttpSession session) {
        session.removeAttribute("user");
        return R.success("退出成功");
    }
}
