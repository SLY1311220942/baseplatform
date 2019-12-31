package com.sly.baseplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web视图配置
 *
 * @author SLY
 * @time 2019/12/31
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 项目根路径默认跳转至home页面
     *
     * @param
     * @return
     * @author SLY
     * @time 2019/12/31
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/index/toHome");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        WebMvcConfigurer.super.addViewControllers(registry);
    }
}
