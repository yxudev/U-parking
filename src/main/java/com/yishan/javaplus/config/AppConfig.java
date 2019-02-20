package com.yishan.javaplus.config;


import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.yishan.javaplus.service.StorageService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

@Configuration
@ComponentScan(basePackages = "com.yishan.javaplus",
    excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com.yishan.javaplus.api.*"))
public class AppConfig {

    @Autowired
    private Environment environment;
    private final Logger logger = getLogger(getClass());

    @Bean(name = "applicationProperties")
    public PropertiesFactoryBean getDbProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        String profile = environment.getActiveProfiles()[0];
        logger.debug("applicationProperties is " + profile);
        bean.setLocation(new ClassPathResource("META-INF/env/application-" + profile + ".properties"));
        return bean;
    }

    @Bean(name = "shareProperties")
    public PropertiesFactoryBean getSharedProperties() {
        PropertiesFactoryBean shareProperties = new PropertiesFactoryBean();
        shareProperties.setLocation(new ClassPathResource("META-INF/share-runtime.properties"));
        return shareProperties;
    }

    @Bean
    @Profile({"dev","test","prod","staging"})
    public StorageService getStorageService() throws IOException {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        StorageService storageService = new StorageService(s3Client);
        storageService.setBucket("miparquelot");
        return storageService;
    }
}
