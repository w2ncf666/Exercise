package com.wcf.service;

import com.wcf.pojo.Book;

import java.util.List;

public interface BookService {

    /**
     * 保存
     * @param book
     * @return
     */
    public Integer save(Book book);




    /**
     * 修改
     * @param book
     * @return
     */
    public Integer update(Book book);





    /**
     * 删除
     * @param id
     * @return
     */
    public Integer delete(Integer id);






    /**
     * 查询单个
     * @param id
     * @return
     */

    public Book getById(Integer id);






    /**
     * 查询所有
     * @return
     */
    public List<Book> getAll();
}
