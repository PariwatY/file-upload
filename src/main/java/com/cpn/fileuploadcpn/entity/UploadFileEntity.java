package com.cpn.fileuploadcpn.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "upload_file", schema = "public")
public class UploadFileEntity {

    @Id
    @Column(name = "file_id", nullable = false, length = 32)
    private String fileId;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "path", length = 100)
    private String path;

    @Column(name = "status")
    private Integer status;

    @Column(name = "create_by", length = 32)
    private String createBy;

    @Column(name = "create_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createDate;

    @Column(name = "update_by", length = 32)
    private String updateBy;

    @Column(name = "update_date")
    private Integer updateDate;
}

