package com.yishan.javaplus.service.jms;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Value;

public class MessageSQSService {

    private AmazonSQS sqs;

    @Value("#{ applicationProperties['amazon.sqs.url'] }")
    private String queueUrl;

    public MessageSQSService(AmazonSQS sqs) {
        this.sqs = sqs;
    }

    public AmazonSQS getMessageSQSService() {
        return sqs;
    }

    public MessageSQSService() {
    }

    public void SendMessageRequest(String message, int time) {

        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(message)
                .withDelaySeconds(time);
        sqs.sendMessage(send_msg_request);
    }

}
