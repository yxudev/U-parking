package com.yishan.javaplus.api;

import com.yishan.javaplus.service.jms.MessageSQSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/sqs")
public class SQSController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSQSService messageSQSService;

}
