package com.cpn.fileuploadcpn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.cpn.fileuploadcpn.entity")
public class FileUploadCpnApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploadCpnApplication.class, args);
	}

}
