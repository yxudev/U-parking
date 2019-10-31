package com.yishan.javaplus.worker.config.jms;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.twilio.Twilio;
import com.twilio.twiml.voice.Sms;
import com.yishan.javaplus.worker.service.SmsSender;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

@Configuration
@ComponentScan(basePackages = "com.yishan.javaplus", excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,pattern = "com.yishan.javaplus.api.*"))
@Profile({"dev", "test", "stage", "prod"})
public class AppConfig {

    @Bean
    public AmazonSQS getAmazonSQS() {
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return amazonSQS;
    }



        @Autowired
        private Environment environment;

        private final Logger logger = getLogger(getClass());

        @Value("${queueName}")
        private String queueName;

        @Bean(name = "application.properties")
        public PropertiesFactoryBean getDbProperties() {
            PropertiesFactoryBean bean = new PropertiesFactoryBean();
            String profile = environment.getActiveProfiles()[0];
            logger.debug("applicationProperties is " + profile);
            bean.setLocation(new ClassPathResource("META-INF/env/application-" + profile + ".properties"));
            return bean;
        }

}
