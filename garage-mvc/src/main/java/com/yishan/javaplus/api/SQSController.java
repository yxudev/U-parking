package com.yishan.javaplus.api;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.waiters.HttpSuccessStatusAcceptor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yishan.javaplus.service.jms.MessageSQSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.AbstractExecutorService;

@RestController
@RequestMapping(value = {"/api/sqs"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class SQSController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSQSService messageSQSService;

    @Autowired
    private AmazonSQS amazonSQS;


//    @RequestMapping(value = "{Id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public Boolean getMessage(@PathVariable("Id") Long messageId, @RequestParam("domainName") String domainName){
//        logger.debug("The message Id is:" + messageId);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("id", messageId.toString());
//        map.put("domainName", domainName);
//        try {
//            messageSQSService.receiveMessage(amazonSQS,"URL");
//        } catch (Exception e){
//            logger.error("Errors", e);
//        }
//        return Boolean.TRUE;
//    }

    @RequestMapping(value = "{Id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Boolean postMessage(@PathVariable("Id") Long messageId, @RequestParam("domainName")String domainName) {
        logger.debug("receive a message id:" + messageId);
        ObjectMapper mapper = new ObjectMapper();
        String json = "";

        Map<String, String> map = new HashMap<>();
        map.put("id", messageId.toString());
        map.put("domainName", domainName);
        try {
            json = mapper.writeValueAsString(map);
            messageSQSService.sendMessage( "Aloha");
        } catch (JsonProcessingException e) {
            logger.error("error message", e);
        }
        return Boolean.TRUE;
    }



}
