package com.wcf.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcf.dao.EmployeeMapper;
import com.wcf.reastic.Employee;
import com.wcf.pojo.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeMapper mapper;


    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {

        String username = employee.getUsername();
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Employee::getUsername, username).eq(Employee::getPassword, password);
        Employee one = mapper.selectOne(lqw);
        System.out.println(one);
        if (one == null)
            return R.error("登陆失败");
        if (one.getStatus() == 0)
            return R.error("此账号被冻结.");
        log.info("333");
        request.getSession().setAttribute("employee", one.getId());
        return R.success(one);


    }


    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        request.getSession().removeAttribute("employee");
        return R.success("employee logout");
    }


    @PostMapping
    public R<String> add(@RequestBody Employee employee) {
        //判断唯一username
        log.info(employee.toString());
//        employee.setCreateTime(LocalDateTime.now());
//        employee.setUpdateTime(LocalDateTime.now());
//        Long creatUser = (Long) request.getSession().getAttribute("employee");
//        Long updateUser = (Long) request.getSession().getAttribute("employee");
//        employee.setCreateUser(creatUser);
        String password = DigestUtils.md5DigestAsHex("123456".getBytes());
        employee.setPassword(password);
//        employee.setUpdateUser(updateUser);
        mapper.insert(employee);
        return R.success("添加成功");
    }

    @GetMapping("/page")
    public R<Page> selectAll(@RequestParam int page, @RequestParam int pageSize, String name) {
        Page<Employee> Page1 = new Page<>(page, pageSize);
        LambdaQueryWrapper<Employee> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(name), Employee::getName, name);
        mapper.selectPage(Page1, lqw);
       /* System.out.println(name);
        Long total = mapper.selectCount(null);
        List<Employee> limit = mapper.limit(page-1, pageSize,name);
        data data = new data(limit, total);*/
        return R.success(Page1);
    }

    @GetMapping("/{id}")
    public R<Employee> review(@PathVariable Long id) {
        Employee employee = mapper.selectById(id);
        return R.success(employee);
    }

    @PutMapping
    public R<String> edit(@RequestBody Employee employee) {

//        employee.setUpdateTime(LocalDateTime.now());
 //       Long updateUser = (Long) request.getSession().getAttribute("employee");
  //      employee.setUpdateUser(updateUser);
  //      employee.setUpdateTime(LocalDateTime.now());
        mapper.updateById(employee);
        return R.success("修改成功");
    }
}
