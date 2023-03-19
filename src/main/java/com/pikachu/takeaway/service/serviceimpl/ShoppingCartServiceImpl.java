package com.pikachu.takeaway.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pikachu.takeaway.entity.ShoppingCart;
import com.pikachu.takeaway.mapper.ShoppingCartMapper;
import com.pikachu.takeaway.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
