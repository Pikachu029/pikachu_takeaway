package com.pikachu.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pikachu.takeaway.entity.Category;
import com.pikachu.takeaway.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 橙子
 * @Date: 2022/11/16 23:27
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
