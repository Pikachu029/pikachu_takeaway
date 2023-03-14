package com.pikachu.takeaway.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pikachu.takeaway.entity.Setmeal;
import com.pikachu.takeaway.mapper.SetmelMapper;
import com.pikachu.takeaway.service.SetmealService;
import org.springframework.stereotype.Service;

/**
 * @Author: 橙子
 * @Date: 2022/11/20 0:02
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmelMapper,Setmeal> implements SetmealService {
}
