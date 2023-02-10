package com.wcf.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcf.Util.HandleIds;
import com.wcf.dao.CategoryMapper;
import com.wcf.dao.DishFlavorMapper;
import com.wcf.dao.DishMapper;
import com.wcf.dto.DishDto;
import com.wcf.dto.DishDto2;
import com.wcf.dto.DishDto3;
import com.wcf.pojo.R;
import com.wcf.reastic.Category;
import com.wcf.reastic.Dish;
import com.wcf.reastic.DishFlavor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*http://localhost/dish/page?page=1&pageSize=10*/
@RestController
@RequestMapping("/dish")
@Slf4j
@Transactional
public class dishController {
    @Autowired
    DishMapper mapper;
    @Autowired
    DishFlavorMapper dishFlavorMapper;
    @Autowired
    CategoryMapper categoryMapper;
/*http://localhost/dish*/

/*http://localhost/dish/list?categoryId=1397844263642378242*/


    @GetMapping("/list")
    public R<List<DishDto3>> selectForSetMeal(Dish dish){
        Long categoryId = dish.getCategoryId();
        String name = dish.getName();
        Integer status = dish.getStatus();
        LambdaQueryWrapper<Dish>lqw=new LambdaQueryWrapper<>();
        lqw.eq(categoryId!=null,Dish::getCategoryId,categoryId);
        lqw.eq(status!=null,Dish::getStatus,status).orderByDesc(Dish::getUpdateTime);
        lqw.like(StringUtils.isNotEmpty(name),Dish::getName,name);
        List<Dish> dishes = mapper.selectList(lqw);
        ArrayList<DishDto3> list = new ArrayList<>();
        for (Dish item : dishes) {//每个item对应一个口味集合
            DishDto3 dishDto3 = new DishDto3();
            BeanUtils.copyProperties(item,dishDto3);
            Long dishId = item.getId();
            LambdaQueryWrapper<DishFlavor>lqw2=new LambdaQueryWrapper<>();
            lqw2.eq(DishFlavor::getDishId,dishId);
            List<DishFlavor> dishFlavors = dishFlavorMapper.selectList(lqw2);
            dishDto3.setFlavors(dishFlavors);
            list.add(dishDto3);
        }
        return R.success(list);
    }


    @PutMapping
    public R<String> update(@RequestBody DishDto3 dish){
        mapper.updateById(dish);
        List<DishFlavor> flavors = dish.getFlavors();//此处可以提取工具类解决冗余
        Long dishId = dish.getId();
        log.info("dishId111:{}",dishId);
        LambdaQueryWrapper<DishFlavor> lqw=new LambdaQueryWrapper<>();
        lqw.eq(DishFlavor::getDishId,dishId);
        dishFlavorMapper.delete(lqw);
        for (DishFlavor flavor : flavors) {
            flavor.setDishId(dishId);
            log.info("dishId这里:{}",flavor.getDishId());
            dishFlavorMapper.insert(flavor);
        }
        return R.success("修改成功");
    }
    @GetMapping("/{id}")
    public R<Dish> review(@PathVariable Long id){
        Dish dish = mapper.selectById(id);
        DishDto3 dishDto3=new DishDto3();
        BeanUtils.copyProperties(dish,dishDto3);
        LambdaQueryWrapper<DishFlavor> lqw=new LambdaQueryWrapper<>();
        lqw.eq(DishFlavor::getDishId,id);
        List<DishFlavor> dishFlavors = dishFlavorMapper.selectList(lqw);
        dishDto3.setFlavors(dishFlavors);
        return R.success(dishDto3);
    }


    @PostMapping
    public R<String> addDish(@RequestBody DishDto3 dish){
        log.info("开始 {}",dish);
        mapper.insert(dish);
        List<DishFlavor> flavors = dish.getFlavors();
        for (DishFlavor flavor : flavors) {
            log.info("第一个{}",flavor.getDishId());
            Long id = dish.getId();
            flavor.setDishId(id);//加了事务,如果不赋值dishId会事务回滚
            log.info("第二个{}",flavor.getDishId());

            dishFlavorMapper.insert(flavor);
        }
        return R.success("添加成功");
    }
    @GetMapping("/page")
    public R<Page> selectAll(int page, int pageSize, String name) {
        log.info(name);
        Page<Dish> page1 = new Page<>(page, pageSize);
        Page<DishDto> page2=new Page<>();
        LambdaQueryWrapper<Dish> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(name), Dish::getName, name);
        mapper.selectPage(page1, lqw);
        BeanUtils.copyProperties(page1,page2,"records");
        log.info("开始1__________________________________");
        log.info(page1.getRecords().toString());
        List<DishDto> list2=new ArrayList<>();
        for (Dish record : page1.getRecords()) {//record 是集合的每一个元素,需要把每一个元素换成另一个元素
            DishDto dishDto=new DishDto();
            BeanUtils.copyProperties(record,dishDto);
            Long categoryId = record.getCategoryId();
            Category id = categoryMapper.selectById(categoryId);
            log.info("我是分割线_________________________________");
            log.info(id.getName());
            dishDto.setCategoryName(id.getName());
            list2.add(dishDto);
        }
        Long total=page1.getTotal();
        page2.setRecords(list2);
        log.info(page2.getTotal()+"  查看总数");
        page2.setTotal(total);
        return R.success(page2);
    }

   /* @GetMapping("/page")
    public R<Page> selectAll(int page, int pageSize, String name) {
        log.info(name);
        Page<Dish> page1 = new Page<>(page, pageSize);
        LambdaQueryWrapper<Dish> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(name), Dish::getName, name);
        mapper.selectPage(page1, lqw);

        return R.success(page1);
        *//*return R.success(new DishDto2(dishDtos,count));*//*
    }*/


    @DeleteMapping
    public R<String> deleteByIds(String ids) {

        List<Long> list = HandleIds.handleIds(ids);
        log.info("开始删除");
        mapper.deleteBatchIds(list);
        for (Long item : list) {
            LambdaQueryWrapper<DishFlavor> lqw=new LambdaQueryWrapper<>();
            log.info("检测ID:{}",item);
            lqw.eq(DishFlavor::getDishId,item);
            dishFlavorMapper.delete(lqw);
        }
        return R.success("删除成功");
    }

    @PostMapping("/status/{flag}")
    public R<String> open(@PathVariable int flag, String ids) {
        log.info("flag:{}", flag);
        List<Long> list = HandleIds.handleIds(ids);
        log.info("开始查找");
        List<Dish> dishList = mapper.selectBatchIds(list);
        for (Dish dish : dishList) {
            dish.setStatus(flag);
            mapper.updateById(dish);
        }
        return R.success(flag == 1 ? "起售成功" : "停售成功");
    }

}