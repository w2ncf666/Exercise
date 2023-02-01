package com.wcf.service.impl;

import com.wcf.dao.BookDao;
import com.wcf.pojo.Book;
import com.wcf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;//代码时期报错
    @Override
    public Integer save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Integer update(Book book) {
       return bookDao.update(book);
    }

    @Override
    public Integer delete(Integer id) {
       return bookDao.delete(id);
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
