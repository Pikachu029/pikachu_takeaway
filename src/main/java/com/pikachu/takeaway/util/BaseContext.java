package com.pikachu.takeaway.util;

/**
 * 基于ThreadLocal的封装工具类，用于保存当前线程数据的副本
 * 作用：存储当前用户的id用于填充公共字段
 * @Author: 橙子
 * @Date: 2022/11/19 22:18
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();


    public static void setEmployeeId(Long id){
        threadLocal.set(id);
    }

    public static Long getEmployeeId() {
        return threadLocal.get();
    }
}
