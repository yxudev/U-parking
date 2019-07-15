package com.yishan.javaplus.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.yishan.javaplus.config.AppConfig;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@WebAppConfiguration
@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("unit")
public class StorageServiceTest{
    File file = new File("/Users/yichenhsu/Documents/AWS/test.pdf");
    String s3Bucket = "unit_test";

    @Autowired
    private StorageService storageService;

    @Autowired
    private AmazonS3 client;

    @After
    public void tearDown() {
        Mockito.reset(client);
    }

    @Test
    public void getObject() {

//        AmazonS3 client = mock(AmazonS3.class);

        String key = "digital/test.pdf";
        storageService.getObject(key, file);
        verify(client, times(1)).getObject(s3Bucket, key);

    }

    @Test
    public void deleteObject() {
        // storageService.getObject("miparquelot", "digital/test.pdf");
        String key = "digital/test.pdf";
        storageService.getObject(key, file);
        verify(client, times(1)).getObject(s3Bucket, key);

    }




//    static List<Bucket> buckets = s3.listBuckets();
//    public static void main(String args[]) {
//        System.out.println("Your Amazon S3 buckets are:");
//        for (Bucket b : buckets) {
//            System.out.println("* " + b.getName());
//        }
//   }
//    public static void main(String[] args) {
//        StorageService s = new StorageService();
//        s.uploadObject("/Users/yichenhsu/Documents/AWS/test.pdf", "miparquelot", "digital/test.pdf");
//        System.out.println("Uploading Completed!\n" + "Please check s3 for the record!\n");
//        StorageService ss = new StorageService();
//        ss.getObject("miparquelot","digital/test.pdf");
//        System.out.println("Downloading Completed!\n" + "Please check your Documents for the record!\n");
//    }
}
