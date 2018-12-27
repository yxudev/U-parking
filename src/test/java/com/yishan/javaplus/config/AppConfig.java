package com.yishan.javaplus.config;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import static org.slf4j.LoggerFactory.getLogger;

@Configuration
@ComponentScan(basePackages = "com.yishan.javaplus",
    excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com.yishan.javaplus.api.*"))
public class AppConfig {

    @Autowired
    private Environment environment;
    private final Logger logger = getLogger(getClass());
    private String propertyKey = "amazon.s3.bucket";

    @Bean(name = "applicationProperties")
    public PropertiesFactoryBean getDbProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        String profile = environment.getActiveProfiles()[0];
        logger.debug("applicationProperties is "+profile);
        bean.setLocation(new ClassPathResource("META-INF/env/application-"+profile+".properties"));
        return bean;
    }
    @Bean(name = "sharePoperties")
    public PropertiesFactoryBean getShareProperties(){
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("META-INF/share-runtime.properties"));
        return bean;
    }

}
