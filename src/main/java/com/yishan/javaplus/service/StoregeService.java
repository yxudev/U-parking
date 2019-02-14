package com.yishan.javaplus.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.File;

public class StoregeService {

    public void uploadObject(String filePath, String bucketName, String fileObjKeyName) {
        System.out.format("Uploading %s to S3 bucket %s...\n\n", filePath, bucketName);
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        try {
            s3.putObject(bucketName, fileObjKeyName, new File(filePath));
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
    }

    public static void main(String[] args) {

        StoregeService s = new StoregeService();

        s.uploadObject("/Users/yichenhsu/Documents/AWS/test.pdf", "miparquelot",
                "digital/test.pdf");

        System.out.println("Job Done!\n" + "Please check s3 for the record!\n");
    }


}