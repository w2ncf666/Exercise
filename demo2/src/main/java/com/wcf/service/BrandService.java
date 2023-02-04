package com.wcf.service;

import com.wcf.pojo.Brand;
import com.wcf.pojo.Page;

public interface BrandService {

   /* List<Brand> selectAll();*/
    void add(Brand brand);

    Brand selectById(int id);
    void update(Brand brand);

    void deleteById(Brand brand);



    void deleteByIds(int[]ids);


    /*List<Brand> selectByConditions(Brand brand);

    List<Brand>selectAllLimit(int begin,int end);
*/
    Integer selectTotalCount(Brand brand);


    Page<Brand> selectByPageAndCondition(int begin, int end, Brand brand);
}
