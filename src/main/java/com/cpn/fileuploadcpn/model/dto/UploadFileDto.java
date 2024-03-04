package com.cpn.fileuploadcpn.model.dto;

import lombok.Data;

@Data
public class UploadFileDto {
    private String fileId;
    private String name;
    private String path;
    private Integer status;
}
