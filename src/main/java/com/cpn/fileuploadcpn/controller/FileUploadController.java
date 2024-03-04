package com.cpn.fileuploadcpn.controller;

import com.cpn.fileuploadcpn.model.response.SuccessResponse;
import com.cpn.fileuploadcpn.exception.FileUploadException;
import com.cpn.fileuploadcpn.service.file.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/file")
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUploadService fileUploadService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public SuccessResponse uploadFile(@RequestParam("file") MultipartFile file,
                                      @RequestParam("bucketName") String bucketName,
                                      @RequestParam("emailTo") String emailTo) {
        try {
            fileUploadService.upload(file, bucketName, emailTo);
            return SuccessResponse.builderSuccess().message("upload file success").build();
        } catch (FileUploadException e) {
            return SuccessResponse.builderFail(e.getMessage()).build();
        }
    }
}
