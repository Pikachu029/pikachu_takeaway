package com.pikachu.takeaway.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pikachu.takeaway.common.R;
import com.pikachu.takeaway.entity.Category;
import com.pikachu.takeaway.entity.Dish;
import com.pikachu.takeaway.entity.DishFlavor;
import com.pikachu.takeaway.entity.Employee;
import com.pikachu.takeaway.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.LambdaMetafactory;
import java.util.List;

/**
 * @Author: 橙子
 * @Date: 2022/11/19 22:54
 */
@RestController
@RequestMapping({"/category"})
@Slf4j
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/page"})
    public R<Page> page(int page, int pageSize){
        log.info("pafe = {},pageSize = {},name = {}",page);

        //构建分页构造器
        Page<Category> page1 = new Page(page, pageSize);

        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        //queryWrapper.like(StringUtils.isNotEmpty(name),Category::getName,name);
        queryWrapper.orderByDesc(Category::getSort);

        categoryService.page(page1,queryWrapper);

        return R.success(page1);
    }


    @PostMapping
    public R<String> save(@RequestBody Category category){

        categoryService.save(category);
        return R.success("新增分类成功");
    }

    /**
     *
     * @param ids
     * @return
     */
    @DeleteMapping
    public R<String> delete(Long ids){
        log.info("id{}",ids);
        categoryService.removeById(ids);
        return R.success("删除成功");
    }

    @PutMapping
    public R<String> update(@RequestBody Category category){
        categoryService.updateById(category);
        return R.success("成功修改");
    }


    /**
     *
     * @param category
     * @return
     */
    @GetMapping({"/list"})
    public R<List<Category>> List(Category category){
        LambdaQueryWrapper<Category> q = new LambdaQueryWrapper<>();
        q.eq(category.getType() != null,Category::getType,category.getType());
        q.orderByAsc(Category::getSort).orderByAsc(Category::getUpdateTime);
        List<Category> list = categoryService.list(q);
        return R.success(list);
    }
}
