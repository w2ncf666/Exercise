package com.wcf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.wcf.service","com.wcf.dao"})
public class SpringConfig {
}
