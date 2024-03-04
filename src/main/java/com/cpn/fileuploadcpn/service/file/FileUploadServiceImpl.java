package com.cpn.fileuploadcpn.service.file;

import com.amazonaws.services.s3.AmazonS3;
import com.cpn.fileuploadcpn.exception.FileUploadException;
import com.cpn.fileuploadcpn.service.email.EmailService;
import com.cpn.fileuploadcpn.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Log4j2
public class FileUploadServiceImpl implements FileUploadService {
    private final AmazonS3 s3client;
    private final EmailService emailService;
    private static final String PATH_DIRECTORY = "fileCpn/";
    private static final String SUBJECT = "[UPLOAD] file upload";
    @Override
    public void upload(MultipartFile file, String bucketName, String emailTo) throws FileUploadException {
        try {
            String filename = "";
            //Check originalFilename before convert filename
            if (file.getOriginalFilename() != null && !"".equals(file.getOriginalFilename())) {
                filename = StringUtil.convertFilename(file.getOriginalFilename());
            }
            //Upload File to AWS S3
            s3client.putObject(bucketName, PATH_DIRECTORY + filename, file.getInputStream(), null);

            //Send mail
            emailService.sendEmail(emailTo, SUBJECT, "I have send file " + filename);
        } catch (Exception e) {
            log.error(e);
            throw new FileUploadException("upload file error");
        }

    }


}
