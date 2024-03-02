package com.cpn.fileuploadcpn.controller;

import com.cpn.fileuploadcpn.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/file")
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUploadService fileUploadService;
    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file")   MultipartFile file){
        System.out.println("file: "  + file.getOriginalFilename());
        fileUploadService.upload();
    }


    @GetMapping("/hello")
    public void hello(){
        System.out.println("file: ");
    }
}
