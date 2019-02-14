package com.yishan.javaplus.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

public class StoregeServiceTest {
    static final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
    static List<Bucket> buckets = s3.listBuckets();

    public static void main(String args[]) {
        System.out.println("Your Amazon S3 buckets are:");
        for (Bucket b : buckets) {
            System.out.println("* " + b.getName());
        }
    }
}