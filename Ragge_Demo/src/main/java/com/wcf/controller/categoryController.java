package com.wcf.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcf.dao.CategoryMapper;
import com.wcf.dao.DishMapper;
import com.wcf.dao.SetMealMapper;
import com.wcf.pojo.R;
import com.wcf.reastic.Category;
import com.wcf.reastic.Dish;
import com.wcf.reastic.Setmeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class categoryController {

    @Autowired
    CategoryMapper mapper;
    @Autowired
    DishMapper dishMapper;
    @Autowired
    SetMealMapper setMealMapper;

    /*http://localhost/category/list?type=1*/

    @GetMapping("/list")
    public R<List<Category>> selectList(Category category) {
        Integer type = category.getType();
        LambdaQueryWrapper<Category> lqw = new LambdaQueryWrapper<>();
        lqw.eq(type != null, Category::getType, type);
        List<Category> categories = mapper.selectList(lqw);
        return R.success(categories);
    }

    @GetMapping("/page")
    public R<Page> selectAll(int page, int pageSize) {
        Page<Category> page1 = new Page<>(page, pageSize);
        LambdaQueryWrapper<Category> lqw = new LambdaQueryWrapper<>();
        lqw.orderByAsc(Category::getSort);
        mapper.selectPage(page1, lqw);
        return R.success(page1);
    }

    @PostMapping
    public R<String> add(@RequestBody Category category) {
        mapper.insert(category);
        return R.success("添加成功");
    }


    @PutMapping
    public R<String> edit(@RequestBody Category category) {
        mapper.updateById(category);
        return R.success("修改成功");
    }

    @DeleteMapping
    public R<String> delete(Long ids) {
        LambdaQueryWrapper<Dish> lqw1 = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Setmeal> lqw2 = new LambdaQueryWrapper<>();
        lqw1.eq(Dish::getCategoryId, ids);
        List<Dish> dishes = dishMapper.selectList(lqw1);
        lqw2.eq(Setmeal::getCategoryId, ids);
        List<Setmeal> setmeals = setMealMapper.selectList(lqw2);
        System.out.println("看这里啊"+setmeals+dishes);
        if (dishes.isEmpty() && setmeals.isEmpty()) {
            mapper.deleteById(ids);
            return R.success("删除成功");
        }
        return R.error("请先删除该分类下的菜品或套餐");
    }
}
