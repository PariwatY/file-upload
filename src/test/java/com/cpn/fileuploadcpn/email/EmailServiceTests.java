package com.cpn.fileuploadcpn.email;

import com.cpn.fileuploadcpn.service.email.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class EmailServiceTests {


    @Autowired
    private EmailService emailService;

    @Test
    void shouldSuccess_WhenSendNormalEmail() {
        emailService.sendEmail("pariwat.y1107@gmail.com", "test2333", "test333");
    }

    @Test
    void shouldSuccess_WhenConvertFileNameTxt() {
        // Arrange
        String originalFilename = "example.txt";
        String expectedExtension = ".txt";

        int dotIndex = originalFilename.lastIndexOf('.');
        String result =   originalFilename.substring(dotIndex);
        // Assert
        assertEquals(expectedExtension, result);
    }


    @Test
    void shouldSuccess_WhenConvertFileNamePng() {
        // Arrange
        String originalFilename = "example.png";
        String expectedExtension = ".png";
        int dotIndex = originalFilename.lastIndexOf('.');
        String result =   originalFilename.substring(dotIndex);
        // Assert
        assertEquals(expectedExtension, result);
    }
}
