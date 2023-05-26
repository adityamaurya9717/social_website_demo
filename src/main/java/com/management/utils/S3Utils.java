package com.management.utils;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;
import java.util.Date;

@Component
public class S3Utils {
    private static final Logger LOGGER = LoggerFactory.getLogger(S3Utils.class);

    @Autowired
    Environment environment;

    @Value("${aws.access-key}")
    private String accessKey;

    @Value("${aws.seceret-key}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.bucket-name}")
    private String bucketName;

    private AmazonS3 amazonS3;

   //@PostConstruct
    public void init() {
        try {
            AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
            this.amazonS3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                    .withRegion(region).build();
        }catch (Exception ex){
            System.out.println(ex);
        }
        String filepath = "/home/moglix/Downloads/amazon1000.txt";
       getS3Path(filepath,"newfile",this.bucketName,"application/txt");

    }

    public String getS3Path(String path, String fileName, String bucketName, String conentType) {
       try {
           String s3BucketName = bucketName;
           PutObjectRequest request = new PutObjectRequest(s3BucketName, fileName, new File(path));
           ObjectMetadata metadata = new ObjectMetadata();
           metadata.setContentType(conentType);
           request.setMetadata(metadata);
           PutObjectResult s3WrittenObject = amazonS3.putObject(request);

           Date expiration = new java.util.Date();
           long expTimeMillis = expiration.getTime();
           expTimeMillis += 1000 * 60 * 60 * 24;
           expiration.setTime(expTimeMillis);
           GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(s3BucketName, fileName).withMethod(HttpMethod.GET)
                   .withExpiration(expiration);
           URL url = amazonS3.generatePresignedUrl(req);
           LOGGER.info("File url" + url.toString());
           return url.toString();
       }
       catch (Exception ex){
           System.out.println(ex);
           return null;
       }
    }




    // delete from s3
    public int deleteObjectFromS3(String filename,String bucketName){
        if(ObjectUtils.isEmpty(filename) ){
            throw new IllegalArgumentException("file name is empty");
        }
        if( ObjectUtils.isEmpty(bucketName)){
            throw new IllegalArgumentException("bucket name is empty");
        }
        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName,filename);
        try {
            amazonS3.deleteObject(deleteObjectRequest);
            return 1;
        }
        catch (AmazonServiceException amazonServiceException){
            LOGGER.error("deleteObjectFromS3 Error getting amazonServiceException file from amazon s3 filename="+filename+","+amazonServiceException.getMessage());
        }
        catch (SdkClientException sdkClientException){
            LOGGER.error("deleteObjectFromS3 Error getting sdkClientException file from amazon s3 filename="+filename+","+sdkClientException.getMessage());
        }
        catch (Exception exception){
            LOGGER.error("deleteObjectFromS3 Error getting exception file from amazon s3 filename="+filename+","+exception.getMessage());
        }
        return 0;
    }



}
