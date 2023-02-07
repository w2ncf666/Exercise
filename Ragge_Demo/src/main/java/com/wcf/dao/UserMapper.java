package com.wcf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcf.reastic.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
