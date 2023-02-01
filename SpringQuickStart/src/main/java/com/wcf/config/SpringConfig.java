package com.wcf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.wcf.text","com.wcf.MyAdvice"})
@PropertySource("classpath:jdbc.properties")
@EnableAspectJAutoProxy
//@EnableTransactionManagement
public class SpringConfig {
}
