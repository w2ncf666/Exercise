package com.wcf;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcf.dao.DishMapper;
import com.wcf.reastic.Dish;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class RaggeDemoApplicationTests {

    @Autowired
    DishMapper mapper;
    @Test
    void contextLoads() {

        /*Page<Dish> page1 = new Page<>(1, 2);
        LambdaQueryWrapper<Dish> lqw = new LambdaQueryWrapper<>();
        mapper.selectPage(page1, lqw);
        System.out.println(page1.getRecords());*/

        System.out.println("16228653936199147542023-02-08T14:29:40.005294200".equals("16228653936199147542023-02-08T14:29:40.005294200"));
    }

}
