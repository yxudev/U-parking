package com.yishan.javaplus.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.service.jms.MessageSQSService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class MessageSQSServiceTest {

        @Autowired
        private MessageSQSService messageSQSService;

        @Autowired
        private AmazonSQS sqsClient;

        @Value("${aws.queueName}")
        private String queueName;

        @Test
        public void sendMessageTest(){
                messageSQSService.sendMessage("aloha");
                Mockito.verify(sqsClient, Mockito.times(1)).sendMessage(Mockito.any());
        }

        @Test
        public void receiveMessageTest(){
                messageSQSService.receiveMessage();
                Mockito.verify(sqsClient, Mockito.times(1)).receiveMessage("URL");
        }
}