package com.pikachu.takeaway.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pikachu.takeaway.entity.OrderDetail;
import com.pikachu.takeaway.mapper.OrderDetailMapper;
import com.pikachu.takeaway.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {

}