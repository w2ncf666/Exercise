package com.wcf.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcf.Util.HandleIds;
import com.wcf.dao.CategoryMapper;
import com.wcf.dao.SetMealDishMapper;
import com.wcf.dao.SetMealMapper;
import com.wcf.dto.SetmealDto;
import com.wcf.pojo.R;
import com.wcf.reastic.DishFlavor;
import com.wcf.reastic.SetmealDish;
import com.wcf.reastic.Setmeal;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/setmeal")
@Transactional
public class setMealController {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    private SetMealMapper setMealMapper;

    @Autowired
    private SetMealDishMapper setMealDishMapper;
  /*  @DeleteMapping
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
    }*/

    @DeleteMapping
    public R<String> deleteByIds(String ids) {
        List<Long> list = HandleIds.handleIds(ids);
        List<Setmeal> setmealList = setMealMapper.selectBatchIds(list);
        for (Setmeal setmeal : setmealList) {
            if (setmeal.getStatus() == 1)
                return R.error("所选删除套餐中含有正在售卖,请先进行下架操作.");
        }
        setMealMapper.deleteBatchIds(list);
        for (Long item : list) {
            LambdaQueryWrapper<SetmealDish> lqw = new LambdaQueryWrapper<>();
            lqw.eq(SetmealDish::getSetmealId, item);
            setMealDishMapper.delete(lqw);
        }
        return R.success("删除套餐成功!");
    }


    @PutMapping
    public R<String> edit(@RequestBody SetmealDto setmealDto) {
        setMealMapper.updateById(setmealDto);
        Long setMealId = setmealDto.getId();
        LambdaQueryWrapper<SetmealDish> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SetmealDish::getSetmealId, setMealId);
        setMealDishMapper.delete(lqw);
        for (SetmealDish setmealDish : setmealDto.getSetmealDishes()) {
            setmealDish.setSetmealId(setMealId);
            setMealDishMapper.insert(setmealDish);
        }
        return R.success("修改套餐成功!");

    }


    @GetMapping("/{id}")
    public R<SetmealDto> review(@PathVariable Long id) {

        SetmealDto setmealDto = new SetmealDto();
        Setmeal setmeal = setMealMapper.selectById(id);
        LambdaQueryWrapper<SetmealDish> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SetmealDish::getSetmealId, id);
        List<SetmealDish> setmealDishList = setMealDishMapper.selectList(lqw);
        BeanUtils.copyProperties(setmeal, setmealDto);
        setmealDto.setSetmealDishes(setmealDishList);
        return R.success(setmealDto);
    }


    @GetMapping("/page")
    public R<Page> selectAll(int page, int pageSize, String name) {//还要处理搜索!!
        Page<Setmeal> page1 = new Page<>(page, pageSize);
        Page<SetmealDto> page2 = new Page<>();
        LambdaQueryWrapper<Setmeal> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(name), Setmeal::getName, name).orderByAsc(Setmeal::getUpdateTime);
        setMealMapper.selectPage(page1, lqw);
        log.info("在这里之前");
        BeanUtils.copyProperties(page1, page2, "records");
        List<SetmealDto> list = new ArrayList<>();
        for (Setmeal record : page1.getRecords()) {
            SetmealDto setmealDto = new SetmealDto();
            Long categoryId = record.getCategoryId();
            log.info(categoryId+"看id");
            String categoryName = categoryMapper.selectById(categoryId).getName();
            setmealDto.setCategoryName(categoryName);
            BeanUtils.copyProperties(record, setmealDto);
            list.add(setmealDto);
        }
        page2.setRecords(list);
        return R.success(page2);
    }

    @PostMapping("/status/{flag}")
    public R<String> open(@PathVariable int flag, String ids) {
        log.info("flag:{}", flag);
        List<Long> list = HandleIds.handleIds(ids);
        log.info("开始查找");
        List<Setmeal> setmeals = setMealMapper.selectBatchIds(list);
        for (Setmeal setmeal : setmeals) {
            setmeal.setStatus(flag);
            setMealMapper.updateById(setmeal);
        }
        return R.success(flag == 1 ? "起售成功" : "停售成功");
    }


    @PostMapping
    public R<String> InsertSetMEal(@RequestBody SetmealDto setmealDto) {

        setMealMapper.insert(setmealDto);
        Long setMealId = setmealDto.getId();
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        for (SetmealDish setmealDish : setmealDishes) {
            setmealDish.setSetmealId(setMealId);
            setMealDishMapper.insert(setmealDish);
        }

        return R.success("添加套餐成功!");
    }


    @GetMapping("/list")
    public R<List<Setmeal>> getSetMeal(Setmeal setmeal){
        Long categoryId = setmeal.getCategoryId();
        Integer status = setmeal.getStatus();
        LambdaQueryWrapper<Setmeal>lqw=new LambdaQueryWrapper<>();
        lqw.eq(Setmeal::getCategoryId,categoryId);
        lqw.eq(Setmeal::getStatus,status).orderByDesc(Setmeal::getUpdateTime);
        List<Setmeal> setmealList = setMealMapper.selectList(lqw);
        return R.success(setmealList);
    }

    //http://localhost/setmeal/page?page=1&pageSize=10
}
