package com.wcf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcf.reastic.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
