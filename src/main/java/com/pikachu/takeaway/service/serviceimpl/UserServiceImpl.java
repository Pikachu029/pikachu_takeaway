package com.pikachu.takeaway.service.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pikachu.takeaway.entity.User;
import com.pikachu.takeaway.mapper.UserMapper;
import com.pikachu.takeaway.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService{
}
