package com.pikachu.takeaway.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pikachu.takeaway.common.R;
import com.pikachu.takeaway.entity.Employee;
import com.pikachu.takeaway.service.EmployeeService;
import com.pikachu.takeaway.service.serviceimpl.EmployrrServiceImpl;
import com.pikachu.takeaway.util.BaseContext;
import com.pikachu.takeaway.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @Author: 橙子
 * @Date: 2022/11/17 15:54
 */
@Slf4j
@RestController
@RequestMapping({"/employee"})
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping({"/login"})
    public R login(HttpServletRequest request, @RequestBody Employee employee){
        //加密页面传来的密码
        String password = MD5Util.MD5Encode(employee.getPassword(), "UTF-8");
        System.out.println(password);
        //根据用户名查询数据库
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Employee :: getUsername,employee.getUsername());
        Employee one = employeeService.getOne(wrapper);
        //查看对象是否为空
        if (one == null){
            return R.error("账户为空");
        }
        if (!password.equals(one.getPassword())){
            return R.error("密码错误");
        }
        if (one.getStatus() == 0){
            return R.error("账户禁止登录");
        }
        request.getSession().setAttribute("employee",one.getId());
        return R.success(one);
    }

    @PostMapping({"/logout"})
    public R logout(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return R.success("退出账号");
    }

    /**
     * 增加员工信息
     * @param request
     * @param employee
     * @return
     */

    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee){
        log.info("增加员工的信息{}",employee.toString());

        //设置初始密码
        String password = MD5Util.MD5Encode("123456", "UTF-8");
        employee.setPassword(password);
        /*//设置时间
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        //获取创建人的id
        Long createId = (Long)request.getSession().getAttribute("employee");
        employee.setCreateUser(createId);
        employee.setUpdateUser(createId);*/

        //前端传来的账号信息进行保存
        //employee是唯一的，如果重复全局异常处理器会进行错误提示
        employeeService.save(employee);

        return R.success("新增员工成功");
    }

    @GetMapping({"/page"})
    public R<Page> page(int page,int pageSize,String name){
        log.info("pafe = {},pageSize = {},name = {}",page,pageSize,name);

        //构建分页构造器
        Page page1 = new Page(page, pageSize);

        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        employeeService.page(page1,queryWrapper);

        return R.success(page1);
    }

    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){



        /*employee.setUpdateUser(emID);
        employee.setUpdateTime(LocalDateTime.now());*/
        employeeService.updateById(employee);

        return R.success("修改成功");
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if (employee != null)
        return R.success(employee);
        return R.error("没有查询到对应员工的信息");
    }
}
