package com.pikachu.takeaway.controller;

import com.pikachu.takeaway.common.R;
import com.pikachu.takeaway.dto.DishDto;
import com.pikachu.takeaway.service.DishFlavorService;
import com.pikachu.takeaway.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *   菜品管理
 * @Author: 橙子
 * @Date: 2022/12/13 18:03
 */
@RestController
@RequestMapping({"/dish"})
public class DishController {
    @Autowired
    DishService dishService;
    @Autowired
    DishFlavorService dishFlavorService;


    @PostMapping
    public R<String> save(@RequestBody DishDto dishDto){



        return R.success("1");
    }
}
