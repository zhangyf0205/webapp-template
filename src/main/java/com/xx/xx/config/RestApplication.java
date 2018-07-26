package com.xx.xx.config;


import com.xx.xx.filters.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by dongwang47 on 2016/8/31.
 */
@ApplicationPath("/*")
public class RestApplication extends ResourceConfig {
    public RestApplication() {

        //服务类所在的包路径
        packages("com"); // 这里需要配置成web路径
        register(LoggingFilter.class);
        //注册JSON转换器,Jersey2.x版本不需要显示注册
        // 只要pom文件中引入相关的
        register(JacksonConfigurator.class);
    }
}
