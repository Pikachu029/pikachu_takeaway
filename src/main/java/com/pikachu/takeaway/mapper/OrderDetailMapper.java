package com.pikachu.takeaway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pikachu.takeaway.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDetailMapper extends BaseMapper<OrderDetail> {

}