package com.pikachu.takeaway.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pikachu.takeaway.entity.Category;
import com.pikachu.takeaway.entity.Employee;

/**
 * @Author: 橙子
 * @Date: 2022/11/16 23:29
 */
public interface CategoryService extends IService<Category> {
    public void removeById(Long id);
}
