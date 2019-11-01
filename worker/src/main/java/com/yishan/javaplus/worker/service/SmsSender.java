package com.yishan.javaplus.worker.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsSender {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${account.sid}")
    private String ACCOUNT_SID;

    @Value("${auth.token}")
    private String AUTH_TOKEN;

    @Value("${recive.number}")
    private String rXNumber;

    @Value("${send.number}")
    private String tXNumber;

    public SmsSender(){
        this.smsSender();
    }

    private void smsSender() {
        logger.debug("Please check your SMS message!");
        Twilio.init("ACCOUNT_SID", "AUTH_TOKEN");
        Message message = Message.creator( new PhoneNumber(rXNumber), new PhoneNumber(tXNumber),"Welcome to the system!").create();
        System.out.println(message.getSid());
    }
}
