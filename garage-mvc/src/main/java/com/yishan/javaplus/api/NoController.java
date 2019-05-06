package com.yishan.javaplus.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/msg"})
public class NoController {

    @RequestMapping(method = RequestMethod.GET)
    public String noController() {
        return "This application is running okay! ";
    }
}