package com.cpn.fileuploadcpn.file;

import com.cpn.fileuploadcpn.exception.FileUploadException;
import com.cpn.fileuploadcpn.service.file.FileUploadService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FileUploadServiceTests {
    @Autowired
    private FileUploadService fileUploadService;

    @Test
    public void shouldSuccess_WhenUploadFileNormalCase() throws Exception {
        byte[] fileContent = "Mock file content".getBytes();
        MultipartFile file = new MockMultipartFile("testFile", "test.txt", "text/plain", fileContent);
        //Correct Bucket
        String bucketName = "bucket-pek2";
        String emailTo = "pek_pariwat02@hotmail.com";
        fileUploadService.upload(file, bucketName, emailTo);
    }

    @Test
    public void shouldFail_WhenUploadFileWrongBucket() throws Exception {
        byte[] fileContent = "Mock file content".getBytes();
        MultipartFile file = new MockMultipartFile("testFile", "test.txt", "text/plain", fileContent);
        // Wrong bucket
        String bucketName = "bucket-pek2";
        String emailTo = "pek_pariwat02@hotmail.com";
        // Assert
        assertThrows(FileUploadException.class, () -> fileUploadService.upload(file, bucketName, emailTo));
    }
}
