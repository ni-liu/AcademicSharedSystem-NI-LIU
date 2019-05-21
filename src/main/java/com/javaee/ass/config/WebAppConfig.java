package com.javaee.ass.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() { return new Class<?>[]{RootConfig.class}; }

    @Override
    protected Class<?>[] getServletConfigClasses() { return new Class<?>[] {WebServletConfig.class}; }

    @Override
    protected String[] getServletMappings() { return new String[] {"/"}; }
}
