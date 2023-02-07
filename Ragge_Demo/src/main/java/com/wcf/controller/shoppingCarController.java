package com.wcf.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wcf.dao.ShoppingCartMapper;
import com.wcf.pojo.R;
import com.wcf.reastic.ShoppingCart;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/shoppingCart")
@Slf4j
public class shoppingCarController {

    @Autowired
    ShoppingCartMapper shoppingCartMapper;


    @PostMapping("/add")
    public R<ShoppingCart> add(@RequestBody ShoppingCart shoppingCart, HttpSession session) {
        /*BigDecimal amount = shoppingCart.getAmount();
        String name = shoppingCart.getName();
        Long setmealId = shoppingCart.getSetmealId();
        Long dishId = shoppingCart.getDishId();
        String image = shoppingCart.getImage();
        LambdaQueryWrapper<ShoppingCart> lqw = new LambdaQueryWrapper<>();
        lqw.eq(dishId != null, ShoppingCart::getDishId, dishId)
                .eq(setmealId != null, ShoppingCart::getSetmealId, setmealId)
                .eq(StringUtils.isNotEmpty(name), ShoppingCart::getName, name);
        lqw.eq(ShoppingCart::getImage, image).eq(ShoppingCart::getAmount, amount);*/
        Long setmealId = shoppingCart.getSetmealId();
        Long dishId = shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> lqw = new LambdaQueryWrapper<>();
        lqw.eq(dishId != null, ShoppingCart::getDishId, dishId)
                .eq(setmealId != null, ShoppingCart::getSetmealId, setmealId);
        ShoppingCart one = shoppingCartMapper.selectOne(lqw);
        if(one==null) {
            Long userId = (Long) session.getAttribute("user");
            shoppingCart.setUserId(userId);
            shoppingCartMapper.insert(shoppingCart);
            return R.success(shoppingCart);
        }
        else {
            Integer number = one.getNumber();
            log.info("书香是{}",number);
            one.setNumber(number+1);
            log.info("1231223撒旦{}",one.getNumber());
            shoppingCartMapper.updateById(one);
            return R.success(one);
        }
    }
}
