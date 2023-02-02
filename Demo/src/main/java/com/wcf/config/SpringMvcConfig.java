package com.wcf.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.wcf.controller","com.wcf.pojo","com.wcf.config"})
@EnableWebMvc
public class SpringMvcConfig {
}
