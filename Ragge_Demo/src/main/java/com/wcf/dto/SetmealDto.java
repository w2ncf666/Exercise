package com.wcf.dto;


import com.wcf.reastic.SetmealDish;
import com.wcf.reastic.Setmeal;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;

}
