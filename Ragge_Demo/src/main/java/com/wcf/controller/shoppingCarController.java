package com.wcf.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wcf.dao.ShoppingCartMapper;
import com.wcf.pojo.R;
import com.wcf.reastic.ShoppingCart;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
@Slf4j
public class shoppingCarController {

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @DeleteMapping("/clean")
    public R<String> clean() {
        shoppingCartMapper.delete(null);
        return R.success("清空购物车成功");
    }


    @GetMapping("/list")
    public R<List<ShoppingCart>> showGoods() {
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectList(null);
        return R.success(shoppingCarts);
    }


    @PostMapping("/sub")
    public R<ShoppingCart> sub(@RequestBody ShoppingCart shoppingCart) {
        Long setmealId = shoppingCart.getSetmealId();
        Long dishId = shoppingCart.getDishId();
        LambdaQueryWrapper<ShoppingCart> lqw = new LambdaQueryWrapper<>();
        lqw.eq(dishId != null, ShoppingCart::getDishId, dishId)
                .eq(setmealId != null, ShoppingCart::getSetmealId, setmealId);
        ShoppingCart one = shoppingCartMapper.selectOne(lqw);
        Integer number = one.getNumber();
        if (number == 1) {
            shoppingCartMapper.deleteById(one);
            one.setNumber(0);
        }
        else {
            one.setNumber(number - 1);
            shoppingCartMapper.updateById(one);
        }
        return R.success(one);
    }


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
        String dishFlavor = shoppingCart.getDishFlavor();
        LambdaQueryWrapper<ShoppingCart> lqw = new LambdaQueryWrapper<>();
        lqw.eq(dishId != null, ShoppingCart::getDishId, dishId)
                .eq(setmealId != null, ShoppingCart::getSetmealId, setmealId)
                .eq(dishFlavor!=null,ShoppingCart::getDishFlavor,dishFlavor);
        ShoppingCart one = shoppingCartMapper.selectOne(lqw);
        if (one == null) {
            Long userId = (Long) session.getAttribute("user");
            shoppingCart.setUserId(userId);
            shoppingCart.setNumber(1);
            shoppingCartMapper.insert(shoppingCart);
            return R.success(shoppingCart);
        } else {
            Integer number = one.getNumber();
            log.info("书香是{}", number);
            one.setNumber(number + 1);
            log.info("1231223撒旦{}", one.getNumber());
            shoppingCartMapper.updateById(one);
            return R.success(one);
        }
    }
}
