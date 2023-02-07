package com.wcf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcf.reastic.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
}
