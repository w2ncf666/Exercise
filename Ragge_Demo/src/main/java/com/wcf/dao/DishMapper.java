package com.wcf.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcf.dto.DishDto;
import com.wcf.reastic.Category;
import com.wcf.reastic.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {


    @Select("SELECT dish.id,dish.name,dish.category_id,dish.price,dish.code,dish.image,dish.description,dish.status,dish.sort,dish.create_time,dish.update_time,dish.create_user,dish.update_user,dish.is_deleted,category.`name` from dish,category where dish.category_id=category.id and dish.`name`like '%#{name}%'limit #{page},#{pageSize}")
    List<DishDto> selectAllUnion(int page,int pageSize,String name);

}
