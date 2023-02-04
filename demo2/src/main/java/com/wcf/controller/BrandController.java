package com.wcf.controller;


import com.wcf.pojo.Brand;
import com.wcf.pojo.Page;
import com.wcf.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

@GetMapping("/{id}")
    //记得配拦截器
public String text(@PathVariable int id){
    System.out.println(id);
    return "333";
}

    @PostMapping("/{currentPage}/{size}")
    public Page<Brand> selectByPageAndCondition(@PathVariable int currentPage, @PathVariable int size, @RequestBody Brand brand) {
        /*System.out.println(begin);
        System.out.println(end);
        System.out.println(brand);*/
        return brandService.selectByPageAndCondition(currentPage, size, brand);
    }


    @RequestMapping("/add")
    public String add(@RequestBody Brand brand) {
        brandService.add(brand);
        return "success";
    }


    @RequestMapping("/selectById")
    public Brand selectById(@RequestBody Brand brand) {
        int id = brand.getId();
        return brandService.selectById(id);
    }

    @PutMapping
    public String update(@RequestBody Brand brand) {
        brandService.update(brand);
        return "success";
    }

    @DeleteMapping
    public String deleteById(@RequestBody Brand brand) {
        brandService.deleteById(brand);
        return "success";
    }


    @RequestMapping("/deleteByIds")
    public String deleteByIds(@RequestBody int[] ids) {
        brandService.deleteByIds(ids);
        return "success";
    }
    /*void add(Brand brand);

 public  Brand selectById(int id);
 public  void update(Brand brand);

 public  void deleteById(Brand brand);



 public  void deleteByIds(int[]ids);


    *//*List<Brand> selectByConditions(Brand brand);

    List<Brand>selectAllLimit(int begin,int end);
*//*
    Integer selectTotalCount(Brand brand);


    Page<Brand> selectByPageAndCondition(int begin, int end, Brand brand);*/

}
