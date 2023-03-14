package com.pikachu.takeaway.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.pikachu.takeaway.entity.Employee;
import com.pikachu.takeaway.util.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: 橙子
 * @Date: 2022/11/19 21:30
 */
@Component
@Slf4j
public class MyMetaObjecthander implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        //设置时间
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());


        //获取创建人的id
        metaObject.setValue("createUser", BaseContext.getEmployeeId());
        metaObject.setValue("updateUser", BaseContext.getEmployeeId());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", BaseContext.getEmployeeId());

    }
}
