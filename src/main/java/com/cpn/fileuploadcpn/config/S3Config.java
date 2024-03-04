package com.cpn.fileuploadcpn.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.cpn.fileuploadcpn.entity.ConfigEntity;
import com.cpn.fileuploadcpn.repository.ConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class S3Config {
    private final ConfigRepository configRepository;

    @Bean
    public AmazonS3 s3client() {
        Optional<ConfigEntity> optAwsKey = configRepository.findById("AWS_ACCESS_KEY");
        Optional<ConfigEntity> optAwsSecret = configRepository.findById("AWS_ACCESS_SECRET");
        String awsKey = "";
        if (optAwsKey.isPresent()) {
            awsKey = optAwsKey.get().getConfigValue();
        }

        String awsSecret = "";
        if (optAwsSecret.isPresent()) {
            awsSecret = optAwsSecret.get().getConfigValue();
        }


        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(awsKey, awsSecret);
        var awsS3Config = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .withRegion(Regions.AP_SOUTHEAST_1) // This field if not exist throws an exception
                .build();
        return awsS3Config;
    }
}