package com.wcf.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcf.reastic.Category;
import com.wcf.reastic.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DishFlavorMapper extends BaseMapper<DishFlavor> {
}
