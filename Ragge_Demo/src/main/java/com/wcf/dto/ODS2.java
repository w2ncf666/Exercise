package com.wcf.dto;

import com.wcf.reastic.Orders;
import lombok.Data;

import java.util.List;

@Data
public class ODS2 extends Orders {


   private List<ODS> orderDetails;//每一个订单对应的菜品


}
