package com.example.lihuan.demo.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.beans.ConstructorProperties;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig
{
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid()
    {
        DruidDataSource ds = new DruidDataSource();
        ds.setMaxActive(10);
        return ds;
    }

    @Bean
    public ServletRegistrationBean statViewServlet()
    {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", "");
        /*initParams.put("deny", "192.168.1.20");*/

        /** 设置初始化参数*/
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置 Druid 监控 之  web 监控的 filter
     * WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
     */
    @Bean("stat")
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        /** exclusions：设置哪些请求进行过滤排除掉，从而不进行统计*/
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);

        /** "/*" 表示过滤所有请求*/
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
