package com.yishan.javaplus.api;

import com.yishan.javaplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController("UtilRestLol")
@RequestMapping(value = "/api/misc")
public class MiscController {

    @Autowired
    private UserService userService;

   // private final Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @RequestMapping(value = "/picture", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public Map<String, String>uploadPicture(@RequestParam(value = "pic") MultipartFile picture) {
        Map<String, String> result = new HashMap<>(1);
        result.put("key1", "sampleUrl");
        return result;
    }
}

