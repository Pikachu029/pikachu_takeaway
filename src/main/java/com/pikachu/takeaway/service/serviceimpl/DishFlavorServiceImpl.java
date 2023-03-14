package com.pikachu.takeaway.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pikachu.takeaway.entity.DishFlavor;
import com.pikachu.takeaway.mapper.DishFlavorMapper;

import com.pikachu.takeaway.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * @Author: 橙子
 * @Date: 2022/11/25 16:21
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
