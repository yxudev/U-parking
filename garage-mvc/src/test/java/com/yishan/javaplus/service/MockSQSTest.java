//package com.yishan.javaplus.service;
//
//import com.amazonaws.services.sqs.AmazonSQS;
//import com.amazonaws.services.sqs.model.*;
//import com.yishan.javaplus.config.AppConfig;
//import com.yishan.javaplus.service.jms.MessageSQSService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertNotNull;
//import static org.junit.Assert.*;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.*;
//import static org.mockito.internal.verification.VerificationModeFactory.times;
//
//@WebAppConfiguration
//@ContextConfiguration(classes = {AppConfig.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles("unit")
//
//@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
//@Configuration
//public class MockSQSTest {
//
//        @Autowired
//        private MessageSQSService messagesqsService;
//
//        @Autowired
//        private AmazonSQS client;
//        @Mock
//        private String queueUrl = "mockUrl";
//        @Mock
//        private int delaySec = 5;
//        @Mock
//        private String msg = "Success!";
//
//        public void Mockito(){}
//
//        @Test
//        public void sendMessageTest(){
//            messagesqsService.sendMessageRequest("xxx");
//            SendMessageRequest sendMsgRequest = new SendMessageRequest()
//                    .withQueueUrl(queueUrl)
//                    .withMessageBody(msg)
//                    .withDelaySeconds(delaySec);
//            verify(client,times(1)).sendMessage(any());
//        }
//}