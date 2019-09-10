package com.yishan.javaplus.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.yishan.javaplus.config.AppConfig;
import com.yishan.javaplus.service.jms.MessageSQSService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class MessageSQSServiceTest {

        @Autowired
        private MessageSQSService messageSQSService;

        @Autowired
        private AmazonSQS client;

        @Test
        public void sendMessageTest(){
            messageSQSService.sendMessage("aloha");
            verify(client,times(1)).sendMessage(any());
        }
}