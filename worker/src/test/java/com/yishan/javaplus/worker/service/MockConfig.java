package com.yishan.javaplus.worker.service;

import com.amazonaws.services.sqs.AmazonSQS;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MockConfig {

        @Bean
        @Profile("unit")
        public AmazonSQS getAmazonSQSBean() {
            AmazonSQS sqsClient = Mockito.mock(AmazonSQS.class);
            return sqsClient;
        }
}
