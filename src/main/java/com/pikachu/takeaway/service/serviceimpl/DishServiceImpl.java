package com.pikachu.takeaway.service.serviceimpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pikachu.takeaway.entity.Dish;
import com.pikachu.takeaway.mapper.DishMapper;
import com.pikachu.takeaway.service.DishService;
import org.springframework.stereotype.Service;

/**
 * @Author: 橙子
 * @Date: 2022/11/20 0:07
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
