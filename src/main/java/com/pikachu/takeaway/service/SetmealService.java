package com.pikachu.takeaway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pikachu.takeaway.dto.SetmealDto;
import com.pikachu.takeaway.entity.Dish;
import com.pikachu.takeaway.entity.Setmeal;

import java.util.List;

/**
 * @Author: 橙子
 * @Date: 2022/11/20 0:01
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids);
}
