package com.pikachu.takeaway.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 * @Author: 橙子
 * @Date: 2022/11/18 20:18
 */
@Slf4j
@ResponseBody
//指定拦截的注解
//拦截类上面加了RestController和Controller注解的异常
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ClobalExceptionHandler {

    /**
     * 唯一字段发生重复时
     * @param ex
     * @return
     */

    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        log.info(ex.getMessage());
        if (ex.getMessage().contains("Duplicate entry")) {
            String[] strings = ex.getMessage().split(" ");
            String s = strings[2] + "已存在";
            return R.error(s);
        }
        return R.error("未知错误");
    }


    @ExceptionHandler({CustomException.class})
    public R<String> exceptionHandler(CustomException ex){
        log.info(ex.getMessage());
        return R.error(ex.getMessage());
    }

}
