package com.pikachu.takeaway;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

import java.util.logging.Logger;

@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableCaching//spring cache 开启缓存注解
public class PikachuTakeawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PikachuTakeawayApplication.class, args);
		System.out.println("启动");
		log.info("启动");
	}

}
