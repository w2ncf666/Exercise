package com.wcf.mapper;

import com.wcf.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    @Select("select * from tb_brand;")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();//查询所有
    Brand selectByid(int id);

    /*
    * 有三种查询方式,
    * 1,散装参数
    * 2,打包成对象传入
    * 3,用map集合传入
    * */
    //1.@param是起别名
    //List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

    //2,传入对象
    //List<Brand> selectByCondition(Brand brand);

    //3传入map集合
    List<Brand> selectByCondition(Map map);
    List<Brand> selectByConditionSingle(Brand brand);
    void add(Brand brand);
    void update(Brand brand);
    void deleteById(int id);
    void deleteByIds(@Param("ids") int[] ids);
}
