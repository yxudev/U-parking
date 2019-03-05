package com.yishan.javaplus.service.jms;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import java.util.List;

public class MessageSQSService {

    private AmazonSQS sqs;

    private String queueUrl;

    public MessageSQSService(AmazonSQS sqs, String queueName) {
        this.sqs = sqs;
        CreateQueueRequest createQueueRequest =
                new CreateQueueRequest(queueName);
        queueUrl = sqs.createQueue(createQueueRequest)
                .getQueueUrl();

    }

    public void sendMessageRequest(String msg) {
        SendMessageRequest req = new SendMessageRequest(queueUrl, msg);
        req.setDelaySeconds(5);
        sqs.sendMessage(req);

//        SendMessageRequest send_msg_request = new SendMessageRequest()
//                .withQueueUrl(queueUrl)
//                .withMessageBody(message)
//                .withDelaySeconds(time);
//        sqs.sendMessage(send_msg_request);
    }

    public void receiveMessageRequest() {
        List<Message> receivedMessages = sqs.receiveMessage(queueUrl).getMessages();
    }
}