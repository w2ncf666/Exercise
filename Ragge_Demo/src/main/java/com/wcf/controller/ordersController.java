package com.wcf.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wcf.Util.HandleIds;
import com.wcf.dao.*;
import com.wcf.dto.ODS;
import com.wcf.dto.ODS2;
import com.wcf.pojo.R;
import com.wcf.reastic.*;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/order")
public class ordersController {

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Autowired
    UserMapper userMapper;
    @Autowired
    AddressMapper addressMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Autowired
    OrdersMapper ordersMapper;

    /*@GetMapping("/userPage")
    public List<String >getOrderDetail() {

        List<String> s=new ArrayList<>();
        s.add("sdjaj");
        s.add("asdsa");
        return s;


    }*/

    @PostMapping("/again")
    public R<String> again(@RequestBody Orders orders, HttpSession session) {
        Long userId = (Long) session.getAttribute("user");
        Long orderId = orders.getId();
        shoppingCartMapper.delete(null);
        Orders order = ordersMapper.selectById(orderId);
        String orderNumber = order.getNumber();
        LambdaQueryWrapper<OrderDetail> lqw = new LambdaQueryWrapper<>();
        lqw.eq(OrderDetail::getOrderId, orderNumber);
        List<OrderDetail> list = orderDetailMapper.selectList(lqw);

        Integer detailNumber;
        BigDecimal amount;
        Long dishId;
        Long setmealId;
        String dishFlavor;
        String image;
        String name;

        for (OrderDetail detail : list) {
            detailNumber = detail.getNumber();
            amount = detail.getAmount();
            dishId = detail.getDishId();
            setmealId = detail.getSetmealId();
            dishFlavor = detail.getDishFlavor();
            image = detail.getImage();
            name = detail.getName();
            ShoppingCart shoppingCart = new ShoppingCart(name,image,userId, dishId, setmealId, dishFlavor, detailNumber, amount);
            shoppingCartMapper.insert(shoppingCart);
        }
        return R.success(null);
    }

    @PutMapping
    public R<String> sendGood(@RequestBody Orders orders) {
        ordersMapper.updateById(orders);
        return R.success("操作成宫");
    }

    @GetMapping("/userPage")//records包含所有订单,是一个list1,list1里是每个订单的所有菜品,是一个list2,list2里是每个菜品的名字和数量,是一个list3
    public R<Page<ODS2>> getOrderDetail(int page, int pageSize, HttpSession session) {
//15:00-17:2--b比骄复杂
        Long userId = (Long) session.getAttribute("user");
        Page<Orders> page1 = new Page<>(page, pageSize);
        Page<ODS2> page2 = new Page<>();
        LambdaQueryWrapper<Orders> lqw1 = new LambdaQueryWrapper<>();
        lqw1.eq(Orders::getUserId, userId).orderByDesc(Orders::getCheckoutTime, Orders::getOrderTime);
        ordersMapper.selectPage(page1, lqw1);
        BeanUtils.copyProperties(page1, page2, "records");

        List<ODS2> listB = new ArrayList<>();
        for (Orders record : page1.getRecords()) {
            ODS2 ods2 = new ODS2();
            BeanUtils.copyProperties(record, ods2);
            String number = record.getNumber();//订单号
            LambdaQueryWrapper<OrderDetail> lqw2 = new LambdaQueryWrapper<>();
            lqw2.eq(OrderDetail::getOrderId, number);
            List<OrderDetail> list = orderDetailMapper.selectList(lqw2);//每个订单下的所有菜
            List<ODS> listA = new ArrayList<>();//一个订单下所有菜的东西
            for (OrderDetail detail : list) {
                listA.add(new ODS(detail.getName(), detail.getNumber()));
            }
            ods2.setOrderDetails(listA);
            listB.add(ods2);
        }
        page2.setRecords(listB);
        return R.success(page2);
    }

    @GetMapping("/page")//@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") Date date2)
    public R<Page<Orders>> employeeOrders(int page, int pageSize, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime beginTime, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endTime, String number) {
        Page<Orders> page1 = new Page<>(page, pageSize);
        LambdaQueryWrapper<Orders> lqw = new LambdaQueryWrapper<>();
        lqw.like(StringUtils.isNotEmpty(number), Orders::getNumber, number);
        if (beginTime != null && endTime != null)
            lqw.between(Orders::getOrderTime, beginTime, endTime);
        ordersMapper.selectPage(page1, lqw);
        return R.success(page1);
    }

    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders, HttpSession session/*,@RequestBody AddressBook addressBook,@RequestBody User user*/) {
/*Orders(id=null, number=null, status=null, userId=null, addressBookId=1622952042647330817, orderTime=null,
checkoutTime=null, payMethod=1, amount=null, remark=asdas, userName=null, phone=null, address=null, consignee=null)*/
        if (session.getAttribute("user") == null)
            return R.error("请先登录!");
        Long userId = (Long) session.getAttribute("user");
        User user = userMapper.selectById(userId);
        //System.out.println(orders);//15011967205
        LambdaQueryWrapper<ShoppingCart> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ShoppingCart::getUserId, userId);
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectList(lqw);
        if (shoppingCarts == null || shoppingCarts.size() == 0) {
            return R.error("购物车为空，不能下单");
            //判断购物车是否为空 健壮性
        }
        String orderId = "" + userId + LocalDateTime.now();//订单号
        Long addressBookId = orders.getAddressBookId();
        AddressBook addressBook = addressMapper.selectById(addressBookId);
        if (addressBook == null) {
            return R.error("用户地址信息有误，不能下单");
        }
        AtomicInteger amount = new AtomicInteger(0);

        List<OrderDetail> orderDetails = shoppingCarts.stream().map((item) -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setNumber(item.getNumber());
            orderDetail.setDishFlavor(item.getDishFlavor());
            orderDetail.setDishId(item.getDishId());
            orderDetail.setSetmealId(item.getSetmealId());
            orderDetail.setName(item.getName());
            orderDetail.setImage(item.getImage());
            orderDetail.setAmount(item.getAmount());
            amount.addAndGet(item.getAmount().multiply(new BigDecimal(item.getNumber())).intValue());
            return orderDetail;
        }).collect(Collectors.toList());


        /*orders.setNumber(orderId);*/
        orders.setOrderTime(LocalDateTime.now());
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setStatus(2);
        orders.setAmount(new BigDecimal(amount.get()));//总金额
        orders.setUserId(userId);
        orders.setNumber(orderId);
        orders.setUserName(user.getName());
        orders.setConsignee(addressBook.getConsignee());
        orders.setPhone(addressBook.getPhone());
        orders.setAddress((addressBook.getProvinceName() == null ? "" : addressBook.getProvinceName())
                + (addressBook.getCityName() == null ? "" : addressBook.getCityName())
                + (addressBook.getDistrictName() == null ? "" : addressBook.getDistrictName())
                + (addressBook.getDetail() == null ? "" : addressBook.getDetail()));
        //向订单表插入数据，一条数据
        // this.save(orders);
        ordersMapper.insert(orders);

        //向订单明细表插入数据，多条数据
        // orderDetailService.saveBatch(orderDetails);
        for (OrderDetail orderDetail : orderDetails) {
            orderDetailMapper.insert(orderDetail);
        }
        //清空购物车数据
        shoppingCartMapper.delete(null);
        /*//获得当前用户id
        Long userId = BaseContext.getCurrentId();

        //查询当前用户的购物车数据
        LambdaQueryWrapper<ShoppingCart> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ShoppingCart::getUserId,userId);
        List<ShoppingCart> shoppingCarts = shoppingCartService.list(wrapper);

        if(shoppingCarts == null || shoppingCarts.size() == 0){
            throw new CustomException("购物车为空，不能下单");
        }

        //查询用户数据
        User user = userService.getById(userId);

        //查询地址数据
        Long addressBookId = orders.getAddressBookId();
        AddressBook addressBook = addressBookService.getById(addressBookId);
        if(addressBook == null){
            throw new CustomException("用户地址信息有误，不能下单");
        }

        long orderId = IdWorker.getId();//订单号

        AtomicInteger amount = new AtomicInteger(0);

        List<OrderDetail> orderDetails = shoppingCarts.stream().map((item) -> {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setNumber(item.getNumber());
            orderDetail.setDishFlavor(item.getDishFlavor());
            orderDetail.setDishId(item.getDishId());
            orderDetail.setSetmealId(item.getSetmealId());
            orderDetail.setName(item.getName());
            orderDetail.setImage(item.getImage());
            orderDetail.setAmount(item.getAmount());
            amount.addAndGet(item.getAmount().multiply(new BigDecimal(item.getNumber())).intValue());
            return orderDetail;
        }).collect(Collectors.toList());


        orders.setId(orderId);
        orders.setOrderTime(LocalDateTime.now());
        orders.setCheckoutTime(LocalDateTime.now());
        orders.setStatus(2);
        orders.setAmount(new BigDecimal(amount.get()));//总金额
        orders.setUserId(userId);
        orders.setNumber(String.valueOf(orderId));
        orders.setUserName(user.getName());
        orders.setConsignee(addressBook.getConsignee());
        orders.setPhone(addressBook.getPhone());
        orders.setAddress((addressBook.getProvinceName() == null ? "" : addressBook.getProvinceName())
                + (addressBook.getCityName() == null ? "" : addressBook.getCityName())
                + (addressBook.getDistrictName() == null ? "" : addressBook.getDistrictName())
                + (addressBook.getDetail() == null ? "" : addressBook.getDetail()));
        //向订单表插入数据，一条数据
        this.save(orders);

        //向订单明细表插入数据，多条数据
        orderDetailService.saveBatch(orderDetails);

        //清空购物车数据
        shoppingCartService.remove(wrapper);*/

        return R.success("订单提交成功");
    }
}
