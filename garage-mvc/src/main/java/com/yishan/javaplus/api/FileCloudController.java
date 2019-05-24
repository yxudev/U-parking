package com.yishan.javaplus.api;

import com.yishan.javaplus.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController("UtilRestLol")
@RequestMapping(value = "/api/misc")
public class FileCloudController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private StorageService storageService;

    @ResponseBody
    @RequestMapping(value = "/picture", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public Map<String, URL> uploadObject(@RequestParam(value = "pic") MultipartFile files) {
        Map<String, URL> result = new HashMap<>(1);
        String homeDir = System.getProperty("catalina.base") != null ? System.getProperty("catalina.base") : "/tmp/";
        String s3Key = files.getOriginalFilename();
        File localFile = new File(homeDir + s3Key);
        try {
            files.transferTo(localFile);
        } catch (IOException e) {
            logger.warn("can't find image file");
        }
        storageService.putObject(s3Key, localFile);
        URL s3Url = storageService.getUrl(s3Key);
        result.put("s3Url", s3Url);
        return result;
    }
}

