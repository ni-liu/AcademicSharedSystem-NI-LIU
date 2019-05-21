package com.javaee.ass.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(
        basePackages ={"com.javaee.ass"} , // 全路径扫描
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION , value = EnableWebMvc.class)}
)
public class RootConfig {
}
