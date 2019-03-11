package com.yishan.javaplus.worker.service;


import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageSQSService {

    @Value("${aws.region}")
    private String region;

    //@Value("#{ applicationProperties['amazon.sqs.url'] }")
    final String queueName = "javaplus-dev";
//    private AmazonSQSClient sqs;

    public void receiveMessage(){
       final AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(region).build();
        List<Message> messages = sqs.receiveMessage(queueName).getMessages();

        for (Message m : messages) {
            sqs.deleteMessage(queueName, m.getReceiptHandle());
        }


    }
}
