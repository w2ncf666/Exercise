package com.wcf.controller;

import com.wcf.pojo.*;
import com.wcf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping
    public Result save(@RequestBody Book book) {
        int flag = bookService.save(book);
        if (flag > 0)
            return new Result(Code.SAVE_OK, "存储成功");
        else return new Result(Code.SAVE_ERR, "存储失败");
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        int flag = bookService.update(book);
        if (flag > 0)
            return new Result(Code.UPDATE_OK, "修改成功");
        else return new Result(Code.UPDATE_ERR, "修改失败");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        bookService.delete(id);
        try {
            int i=1/0;
        } catch (Exception e) {
            System.out.println("zheli");
            throw new SystemException(Code.SYSTEM_ERR,"服务器超时");
        }
        return new Result(Code.DELETE_OK, "删除成功");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        if(id==3)
            throw new SystemException(Code.SYSTEM_ERR,"不能查3");
        Book book = bookService.getById(id);
        if (book != null)
            return new Result(book, Code.GET_OK, "查询单个成功");
        else return new Result(null, Code.GET_ERR, "查询对应的id不存在");


    }

    @GetMapping
    public Result getAll() {
        List<Book> books = bookService.getAll();
        if (books != null)
            return new Result(books, Code.GET_OK, "查询成功");
        else return new Result(null, Code.GET_ERR, "请稍后再试");
    }
}
