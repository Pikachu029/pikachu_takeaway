package com.pikachu.takeaway.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pikachu.takeaway.entity.SetmealDish;
import com.pikachu.takeaway.mapper.SetmealDishMapper;
import com.pikachu.takeaway.service.SetmealDishService;
import com.pikachu.takeaway.entity.SetmealDish;
import com.pikachu.takeaway.mapper.SetmealDishMapper;
import com.pikachu.takeaway.service.SetmealDishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService {
}
