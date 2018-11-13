package com.huayun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.util.StringUtils;
import org.springframework.web.WebApplicationInitializer;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HuayunApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuayunApplication.class, args);
	}
}

