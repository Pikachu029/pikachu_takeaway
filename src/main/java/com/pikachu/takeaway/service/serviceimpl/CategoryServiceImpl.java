package com.pikachu.takeaway.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pikachu.takeaway.common.CustomException;
import com.pikachu.takeaway.entity.Category;
import com.pikachu.takeaway.entity.Dish;
import com.pikachu.takeaway.entity.Setmeal;
import com.pikachu.takeaway.mapper.CategoryMapper;
import com.pikachu.takeaway.service.CategoryService;
import com.pikachu.takeaway.service.DishService;
import com.pikachu.takeaway.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 橙子
 * @Date: 2022/11/16 23:30
 */
@Service
@Slf4j
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;

    @Autowired
    private SetmealService setmealService;

    @Override
    public void removeById(Long id) {
        //查询菜品是否关联分类id
        LambdaQueryWrapper<Dish> dishwrapper = new LambdaQueryWrapper<>();
        dishwrapper.eq((Dish::getCategoryId), id);
        log.info("id = {}",id);
        long count = dishService.count(dishwrapper);
        if (count > 0) {
            throw new CustomException("有相关菜品关联该分类");
        }

        //查询套餐是否关联分类id
        LambdaQueryWrapper<Setmeal> setmealwrapper = new LambdaQueryWrapper<>();
        setmealwrapper.eq((Setmeal::getCategoryId), id);
        long count1 = setmealService.count(setmealwrapper);
        if (count1 > 0) {
            throw new CustomException("有相关套餐关联该分类");
        }

        //该分类id没有关联的数据，直接删除
        super.removeById(id);
    }
}
