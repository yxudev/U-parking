package com.yishan.javaplus.worker.config.jms;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile({"dev", "test", "stage", "prod"})
public class AppConfig {
    @Bean
    public AmazonSQS getAmazonSQS() {
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return amazonSQS;

    }
}
