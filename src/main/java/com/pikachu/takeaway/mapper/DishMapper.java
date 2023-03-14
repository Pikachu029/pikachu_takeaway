package com.pikachu.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pikachu.takeaway.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: 橙子
 * @Date: 2022/11/19 23:59
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
