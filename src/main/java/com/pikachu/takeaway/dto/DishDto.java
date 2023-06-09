package com.pikachu.takeaway.dto;


import com.pikachu.takeaway.entity.Dish;
import com.pikachu.takeaway.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据传输对象，封装页面提交的数据
 */
@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
