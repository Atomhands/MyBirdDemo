package com.niehao.config;


import com.niehao.auth.ViewInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan({"com.niehao.controller", "com.niehao.handler"})
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/bossmain").setViewName("boss/main");
        //registry.addViewController("/views/boss/listEmp").setViewName("boss/redirectEmp");
        registry.addViewController("/boss/listEmp");
        registry.addViewController("/bossListEmp").setViewName("boss/listEmp");
        registry.addViewController("/views/boss/listEmp").setViewName("boss/listEmp");
        //registry.addViewController("/emp/list");

        //user
        registry.addViewController("/userMain").setViewName("user/userMain");
        registry.addViewController("/getTime").setViewName("user/getTime");
        registry.addViewController("/calculateBaZi").setViewName("user/getLoginTime");
        registry.addViewController("/getLoginTime").setViewName("user/saveTime");
     }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ViewInterceptor()).addPathPatterns("/views/**");
    }
}
