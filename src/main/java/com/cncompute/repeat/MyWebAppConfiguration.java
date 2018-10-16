package com.cncompute.repeat;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 把本地服务器路径变为静态路径
 * @author 劉
 *2018年8月8日15:40:10
 */
@SuppressWarnings("deprecation")
@Configuration
public class MyWebAppConfiguration  extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {   
    /**
    * @Description: 对文件的路径进行配置,创建一个虚拟路径/Path/** ，即只要在<img src="/Path/picName.jpg" />便可以直接引用图片
    *这是图片的物理路径  "file:/+本地图片的地址"
    */
    	registry.addResourceHandler("/Path/**").addResourceLocations("file:/D:/aim/");
        super.addResourceHandlers(registry);
    }
} 
