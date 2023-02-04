package com.wcf;

import com.wcf.dao.BrandMapper;
import com.wcf.pojo.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo2ApplicationTests {

    @Autowired
    BrandMapper brandMapper;
    @Test
    void contextLoads() {
        Brand brand=new Brand();
        brand.setBrandName("小米");
        System.out.println(brandMapper.selectById(2));
        System.out.println(brandMapper.selectTotalCount(brand));
    }

}
