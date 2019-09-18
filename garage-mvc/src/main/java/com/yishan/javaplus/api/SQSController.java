package com.yishan.javaplus.api;

import com.yishan.javaplus.service.jms.MessageSQSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = {"/api/sqs"}, produces = MediaType.APPLICATION_JSON_VALUE)
public class SQSController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSQSService messageSQSService;


    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sendMessenge(){
        logger.debug("Start to send new messages!");
        messageSQSService.sendMessage("Los VIN");
        return "Sent successful!";
    }



}
