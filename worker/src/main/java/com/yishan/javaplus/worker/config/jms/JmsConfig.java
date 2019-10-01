package com.yishan.javaplus.worker.config.jms;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.yishan.javaplus.worker.service.JmsSqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import javax.jms.Session;

@Configuration
@EnableJms
public class JmsConfig {
    @Value("${aws.region}")
    private String region;

    @Bean
    public AmazonSQS getAmazonSQS() {
        AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard().withCredentials(new DefaultAWSCredentialsProviderChain()).build();
        return amazonSQS;

    }

    @Bean(name = "connectionFactory")
    public SQSConnectionFactory getSQSConnectionFactory() {
        AmazonSQS amazonSQS = AmazonSQSClientBuilder
                .standard()
                .withCredentials(new DefaultAWSCredentialsProviderChain())
                .withRegion(region)
                .build();
        SQSConnectionFactory sqsConnectionFactory = new SQSConnectionFactory(new ProviderConfiguration(), amazonSQS);
        return sqsConnectionFactory;
    }

    @Bean
    public JmsTemplate getJmsTemplate(@Autowired SQSConnectionFactory sqsConnectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(sqsConnectionFactory);
        return jmsTemplate;
    }

    @Bean
    public DynamicDestinationResolver getDynamicDestinationResolver() {
        return new DynamicDestinationResolver();
    }

    @Bean(name = "jmsListenerContainerFactory")
    @DependsOn("connectionFactory")
    public DefaultJmsListenerContainerFactory getDefaultJmsListenerContainerFactory(@Autowired SQSConnectionFactory connectionFactory, @Autowired DynamicDestinationResolver dynamicDestinationResolver) {
        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerContainerFactory.setSessionTransacted(false);
        jmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        jmsListenerContainerFactory.setDestinationResolver(dynamicDestinationResolver);
        jmsListenerContainerFactory.setConcurrency("1");
        jmsListenerContainerFactory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        return jmsListenerContainerFactory;
    }
}