package com.wcf.dto;

import com.wcf.reastic.Dish;
import lombok.Data;
import org.apache.tomcat.util.descriptor.web.SecurityRoleRef;


@Data
public class DishDto extends Dish {

    private String categoryName;


}
