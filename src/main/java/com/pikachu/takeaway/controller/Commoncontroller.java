package com.pikachu.takeaway.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.pikachu.takeaway.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 *图片上传下载
 * @Author: 橙子
 * @Date: 2022/11/20 17:53
 */
@Slf4j
@RestController
@RequestMapping({"/common"})
public class Commoncontroller {
    @Value("${pikachu.path}")//application.propertise中进行配置
    private String basePath;

    /**
     * 上传图片
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {//file是一个临时文件，需要把他转存到其他位置

        //原始文件名
        String filename = file.getOriginalFilename();
        //截取文件名"."后的后缀
        String substring = filename.substring(filename.lastIndexOf("."));

        //使用UUID重新生成文件名，以确保文件不被同名文件覆盖，并加上截取到的原文件的后缀
        String uuid = UUID.randomUUID().toString() + substring;

        //如果配置的目录文件不存在则新建一个目录
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        log.info(dir.getAbsolutePath());

        try {
            //临时文件转存到指定位置
            log.info("文件名{}{}", basePath, uuid);
            file.transferTo(new File(basePath + uuid));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(uuid);
    }

    /**
     * 下载图片进行回显
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void dowmload(String name, HttpServletResponse response) {

        try {
            //输入流读取文件内容
            FileInputStream in = new FileInputStream(new File(basePath + name));
            //输出流
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            int count = -1;
            String line = null;
            while ((count = in.read()) != -1) {
                out.write(count);
                out.flush();
            }

            //需要传的文件是图片
            response.setContentType("image/jpeg");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
