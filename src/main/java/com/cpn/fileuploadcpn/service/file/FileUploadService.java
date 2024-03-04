package com.cpn.fileuploadcpn.service.file;


import com.cpn.fileuploadcpn.exception.FileUploadException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    void upload(MultipartFile file, String bucketName, String emailTo) throws FileUploadException;
}
