package com.wcf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcf.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BrandMapper extends BaseMapper<Brand> {


    @Select("select * from tb_brand;")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();



    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status});")
    @ResultMap("brandResultMap")
    Integer add(Brand brand);


    @Select("select * from tb_brand where id=#{id};")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    @Update("update tb_brand set brand_name = #{brandName},company_name = #{companyName},ordered = #{ordered},description = #{description},status = #{status} where id = #{id}")
    Integer update(Brand brand);



    @Delete("delete from tb_brand where id=#{id};")
    Integer deleteById1(Brand brand);




    Integer deleteByIds(@Param("ids") int[]ids);



    List<Brand>selectByConditions(Brand brand);


    @Select("select * from tb_brand limit #{begin},#{end};")
    @ResultMap("brandResultMap")
    List<Brand>selectAllLimit(@Param("begin") int begin,@Param("end")int end);


    Integer selectTotalCount(Brand brand);


    List<Brand> selectByPageAndCondition(@Param("begin")int begin,@Param("end")int end,@Param("brand")Brand brand);
}
