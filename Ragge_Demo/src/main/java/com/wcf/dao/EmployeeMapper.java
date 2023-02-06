package com.wcf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wcf.reastic.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    
    
    @Select("select * from employee limit #{page},#{pageSize}")
    List<Employee> limit(int page,int pageSize,String name);
}
