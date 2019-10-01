package com.yishan.javaplus.service.jms;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.*;
import org.geolatte.geom.M;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSQSService {

    private AmazonSQS sqs;
    private String queueUrl;

    public MessageSQSService(@Autowired AmazonSQS sqs, @Value("${aws.queueName}")String queueName){
        this.sqs=sqs;
        this.queueUrl= getQueueUrl(queueName);
    }

    private String getQueueUrl(String queueName){
        GetQueueUrlResult getQueueUrlResult = sqs.getQueueUrl(queueName);
        String queueUrl = getQueueUrlResult.getQueueUrl();
        return queueUrl;
    }

    public void sendMessage(String messageBody) {
        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(this.queueUrl)
                .withMessageBody(messageBody);
        sqs.sendMessage(sendMessageRequest);
    }

    public void receiveMessage(){
        sqs.receiveMessage(queueUrl);
    }

}

