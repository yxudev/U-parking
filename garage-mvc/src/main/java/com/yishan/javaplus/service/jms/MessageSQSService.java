package com.yishan.javaplus.service.jms;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.util.List;

public class MessageSQSService {

    private AmazonSQS sqs;

    private String queueUrl;
    private String queueName;

    public MessageSQSService(AmazonSQS sqs, String queueName) {
        this.sqs = sqs;
        this.queueName = queueName;
        CreateQueueRequest createQueueRequest = new CreateQueueRequest(queueName);
    //    queueUrl = sqs.createQueue(createQueueRequest)
    //                  .getQueueUrl();

    }

    public void sendMessageRequest(String msg) {
        String queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(msg)
                .withDelaySeconds(5);
        sqs.sendMessage(send_msg_request);
    }

    public void receiveMessageRequest() {
        String queueUrl = sqs.getQueueUrl(queueName).getQueueUrl();
        List<Message> receivedMessages = sqs.receiveMessage(queueUrl).getMessages();
    }
}