package com.wcf.dao;


import com.wcf.pojo.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {


    @Insert("insert into tbl_book (type, name, description) values (#{type},#{name},#{description});")
    public Integer save(Book book);


    @Update("update tbl_book set type = #{type}, name=#{name}, description=#{description} where id=#{id};")
    public Integer update(Book book);

    @Delete("delete from tbl_book where id =#{id};")
    public Integer delete(Integer id);

    @Select("select * from tbl_book where id=#{id};")
    public Book getById(Integer id);


    @Select("select * from tbl_book;")
    public List<Book> getAll();
}
