package com.wcf;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcf.dao.DishMapper;
import com.wcf.reastic.Dish;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RaggeDemoApplicationTests {

    @Autowired
    DishMapper mapper;
    @Test
    void contextLoads() {

        Page<Dish> page1 = new Page<>(1, 2);
        LambdaQueryWrapper<Dish> lqw = new LambdaQueryWrapper<>();
        mapper.selectPage(page1, lqw);
        System.out.println(page1.getRecords());
    }

}
