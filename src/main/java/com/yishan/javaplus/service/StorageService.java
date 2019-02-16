package com.yishan.javaplus.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

import static org.slf4j.LoggerFactory.getLogger;

public class StoregeService {
    private AmazonS3 s3;
    private String bucket;
    @Value("#{ applicationProperties['amazon.s3.url'] }")
    private String cdnUrl;

    private final Logger logger = getLogger(getClass());

    public void uploadObject(String filePath, String bucketName, String fileObjKeyName) {
        logger.info("Uploading to S3 bucket...\n\n", filePath, bucketName);
        //System.out.format("Uploading %s to S3 bucket %s...\n\n", filePath, bucketName);
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        try {
            s3.putObject(bucketName, fileObjKeyName, new File(filePath));
        } catch (AmazonServiceException e) {
            logger.error(e.getErrorMessage());
            // System.err.println(e.getErrorMessage());
            //System.exit(1);
        }
    }
//    public void getObject(String bucketName, String fileObjKeyName) {
//
//            new GetObjectRequest(bucketName, fileObjKeyName);
//            File file = new File(("/Users/yichenhsu/Documents/AWS/DLD/"));
//    }



//    public void getObject(String bucketName, String fileObjKeyName) {
//        logger.info("Downloading from S3 bucket...\n\n", bucketName);
//        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
//        try {
//            s3.getObject(bucketName, fileObjKeyName);
//        } catch (AmazonServiceException e) {
//            logger.error(e.getErrorMessage());
//            //System.exit(1);
//        }
//    }

    public void putObject(String S3key, File file) {
        s3.putObject(bucket, S3key, file);
    }

    public void putObject(String bucket, String S3key, File file) {
        s3.putObject(bucket, S3key, file);
    }

    public S3Object getObject(String S3key) {
        return s3.getObject(bucket, S3key);
    }

    public S3Object getObject(String bucket, String S3key) {
        return s3.getObject(bucket, S3key);
    }

}