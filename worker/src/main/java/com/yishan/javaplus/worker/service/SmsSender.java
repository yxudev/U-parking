package com.yishan.javaplus.worker.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Service
public class SmsSender {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("#{${$application.properties}['ACCOUNT_SID']}")
    private String ACCOUNT_SID;

    @Value("#{${$application.properties}['AUTH_TOKEN']}")
    private String AUTH_TOKEN;

    @Value("#{${$application.properties}['rXNumber']}")
    private String rXNumber;

    @Value("#{${application.properties}['tXNumber']}")
    private String tXNumber;


    private void smsSender() {
        logger.debug("Please check your SMS message!");
        Twilio.init("ACCOUNT_SID", "AUTH_TOKEN");
        Message message = Message.creator( new PhoneNumber(rXNumber), new PhoneNumber(tXNumber),"Welcome to the system!").create();
        System.out.println(message.getSid());
    }

    public static void main(String[] args) {
        SmsSender smsSender = new SmsSender();
        smsSender.smsSender();
    }
}
